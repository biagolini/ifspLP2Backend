package br.edu.ifsp.spo.clientdataprocessor.controller;

import br.edu.ifsp.spo.clientdataprocessor.dto.PhoneNumberDto;
import br.edu.ifsp.spo.clientdataprocessor.service.PhoneNumberService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

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

}
