package br.edu.ifsp.spo.clientdataprocessor.controller;

import br.edu.ifsp.spo.clientdataprocessor.dto.UserDto;
import br.edu.ifsp.spo.clientdataprocessor.dto.UserForm;
import br.edu.ifsp.spo.clientdataprocessor.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
@AllArgsConstructor
public class UserController {

    private final ConversionService conversionService;

    private final UserService userService;

    @GetMapping
    public @ResponseBody
    Page<UserDto> findAllPaginated(
            @RequestParam(required = false) String query,
            @RequestParam(required = false) Long idLocationType,
            @RequestParam(required = false) Long idRegionType,
            @RequestParam(required = false) Double latitudeMax,
            @RequestParam(required = false) Double latitudeMin,
            @RequestParam(required = false) Double longitudeMax,
            @RequestParam(required = false) Double longitudeMin,
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable pageable
    ) {
        if (query == null && idLocationType == null && idRegionType == null && latitudeMax == null && latitudeMin == null&& longitudeMax == null && longitudeMin == null  ) { // Se não tem parametros, busca sem filtros
            Page<UserDto> pageReturnObject = this.userService
                    .findAll(pageable)
                    .map(entity -> this.conversionService.convert(entity, UserDto.class));
            pageReturnObject = this.userService.fillMissingDtoData(pageReturnObject);

            return pageReturnObject;
        }

        Page<UserDto> pageReturnObject = this.userService
                .findAll(pageable, query, idLocationType, idRegionType, latitudeMax,  latitudeMin,  longitudeMax,  longitudeMin)
                .map(entity -> this.conversionService.convert(entity, UserDto.class));
        pageReturnObject = this.userService.fillMissingDtoData(pageReturnObject);
        return pageReturnObject;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable Long id) {
        UserDto response = this.userService.findUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PostMapping()
    public ResponseEntity<?> createCustomer(@RequestBody UserForm form) {
        this.userService.createUser(form);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> inactiveCustomer(@PathVariable Long id) {
        this.userService.inactiveUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody UserForm form) {
        this.userService.updateUser(id, form);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
