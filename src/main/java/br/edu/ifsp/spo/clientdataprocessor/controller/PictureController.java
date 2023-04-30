package br.edu.ifsp.spo.clientdataprocessor.controller;

import br.edu.ifsp.spo.clientdataprocessor.dto.PictureDto;
import br.edu.ifsp.spo.clientdataprocessor.service.PictureService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

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

}
