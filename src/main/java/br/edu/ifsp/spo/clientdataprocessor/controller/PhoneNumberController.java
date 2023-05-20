package br.edu.ifsp.spo.clientdataprocessor.controller;

import br.edu.ifsp.spo.clientdataprocessor.dto.PhoneNumberDto;
import br.edu.ifsp.spo.clientdataprocessor.dto.PhoneNumberForm;
import br.edu.ifsp.spo.clientdataprocessor.service.PhoneNumberService;
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

import java.util.List;

@RestController
@RequestMapping("api/phone")
@AllArgsConstructor
public class PhoneNumberController {

    private final ConversionService conversionService;

    private final PhoneNumberService phoneNumberService;

    @GetMapping
    public @ResponseBody
    Page<PhoneNumberDto> findAllPaginated(
            @RequestParam(required = false) String query,
            @RequestParam(required = false) Long idPhoneNumberType,
            @RequestParam(required = false) Long userId,
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable pageable
    ) {

        if (query == null && idPhoneNumberType == null && userId == null ) { // Se não tem parametros, busca sem filtros
            Page<PhoneNumberDto> pageReturnObject = this.phoneNumberService
                    .findAll(pageable)
                    .map(entity -> this.conversionService.convert(entity, PhoneNumberDto.class));
            return pageReturnObject;
        }

        Page<PhoneNumberDto> pageReturnObject = this.phoneNumberService
                .findAll(pageable, query, idPhoneNumberType, userId) // busca pela query
                .map(entity -> this.conversionService.convert(entity, PhoneNumberDto.class));
        return pageReturnObject;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findPhoneNumberById(@PathVariable Long id) {
        PhoneNumberDto response = this.phoneNumberService.findPhoneNumberById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/findByUserId/{id}")
    public ResponseEntity<?> findPhoneNumberByUserId(@PathVariable Long id) {
        List<PhoneNumberDto> response = this.phoneNumberService.findPhoneNumberByUserId(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @PostMapping()
    public ResponseEntity<?> createPhone(@RequestBody PhoneNumberForm form) {
        this.phoneNumberService.createPhoneNumber(form);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> inactivePhone(@PathVariable Long id) {
        this.phoneNumberService.inactivePhoneNumber(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> updatePhone(@PathVariable Long id, @RequestBody PhoneNumberForm form) {
        this.phoneNumberService.updatePhoneNumber(id, form);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
