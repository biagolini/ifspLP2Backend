package br.edu.ifsp.spo.clientdataprocessor.controller;

import br.edu.ifsp.spo.clientdataprocessor.dto.PhoneNumberDto;
import br.edu.ifsp.spo.clientdataprocessor.dto.PictureDto;
import br.edu.ifsp.spo.clientdataprocessor.dto.PictureForm;
import br.edu.ifsp.spo.clientdataprocessor.service.PictureService;
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
@RequestMapping("api/picture")
@AllArgsConstructor
public class PictureController {

    private final ConversionService conversionService;

    private final PictureService pictureService;

    @GetMapping
    public @ResponseBody
    Page<PictureDto> findAllPaginated(
            @RequestParam(required = false) String query,
            @RequestParam(required = false) Long userId,
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable pageable
    ) {
        if (query == null && userId == null ) { // Se não tem parametros, busca sem filtros
        Page<PictureDto> pageReturnObject = this.pictureService
                .findAll(pageable)
                .map(entity -> this.conversionService.convert(entity, PictureDto.class));
        return pageReturnObject;
        }

        Page<PictureDto> pageReturnObject = this.pictureService
                .findAll(pageable, query, userId)
                .map(entity -> this.conversionService.convert(entity, PictureDto.class));
        return pageReturnObject;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findPictureById(@PathVariable Long id) {
        PictureDto response = this.pictureService.findPictureById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/findByUserId/{id}")
    public ResponseEntity<?> findPictureByUserId(@PathVariable Long id) {
        PictureDto response = this.pictureService.findPictureByUserId(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



    @PostMapping()
    public ResponseEntity<?> createPicture(@RequestBody PictureForm form) {
        this.pictureService.createPicture(form);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> inactivePicture(@PathVariable Long id) {
        this.pictureService.inactivePicture(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> updatePicture(@PathVariable Long id, @RequestBody PictureForm form) {
        this.pictureService.updatePicture(id, form);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
