package br.edu.ifsp.spo.clientdataprocessor.controller;

import br.edu.ifsp.spo.clientdataprocessor.dto.enumeration.*;
import br.edu.ifsp.spo.clientdataprocessor.service.EnumerationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("types")
@AllArgsConstructor
public class EnumerationController {

    private final EnumerationService enumerationService;

    @GetMapping("/getGender")
    public ResponseEntity<?> getGender() {
        List<TypeGenderDto> dto = this.enumerationService.getGender();
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @GetMapping("/getLocation")
    public ResponseEntity<?> getLocation() {
        List<TypeLocationDto> dto = this.enumerationService.getLocation();
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping("/getLogin")
    public ResponseEntity<?> getLogin() {
        List<TypeLoginDto> dto = this.enumerationService.getLogin();
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping("/getNationality")
    public ResponseEntity<?> getNationality() {
        List<TypeNationalityDto> dto = this.enumerationService.getNationality();
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping("/getPhoneNumber")
    public ResponseEntity<?> getPhoneNumber() {
        List<TypePhoneNumberDto> dto = this.enumerationService.getPhoneNumber();
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping("/getRegion")
    public ResponseEntity<?> getRegion() {
        List<TypeRegionDto> dto = this.enumerationService.getRegion();
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping("/getState")
    public ResponseEntity<?> getState() {
        List<TypeStateDto> dto = this.enumerationService.getState();
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping("/getTimeZone")
    public ResponseEntity<?> getTimeZone() {
        List<TypeTimeZoneDto> dto = this.enumerationService.getTimeZone();
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

}
