package br.edu.ifsp.spo.clientdataprocessor.controller;

import au.com.bytecode.opencsv.CSVReader;
import br.edu.ifsp.spo.clientdataprocessor.dto.CSVForm;
import br.edu.ifsp.spo.clientdataprocessor.dto.UserDto;
import br.edu.ifsp.spo.clientdataprocessor.dto.UserForm;
import br.edu.ifsp.spo.clientdataprocessor.dto.WrapperForm;
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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.web.multipart.MultipartFile;


import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

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

    @PostMapping("/json")
    public ResponseEntity<?> createCustomerByJson(@RequestBody List<WrapperForm> form) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String json = mapper.writeValueAsString(form);
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/csv")
    public ResponseEntity<?> createCustomerByCsv(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("Please select a CSV file to upload.", HttpStatus.BAD_REQUEST);
        } else {
            try {
                // Create a Reader to read the file
                Reader reader = new InputStreamReader(file.getInputStream());

                // Use OpenCSV to parse the file
                CsvToBean<CSVForm> csvToBean = new CsvToBeanBuilder<CSVForm>(reader)
                        .withType(CSVForm.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                // Loop through beans
                Iterator<CSVForm> csvUserIterator = csvToBean.iterator();

                while (csvUserIterator.hasNext()) {
                    CSVForm csvForm = csvUserIterator.next();

                    // Convert the CSVForm to WrapperForm
                    WrapperForm form = WrapperForm.toWrapperForm(csvForm);

                    // Print the form
                    ObjectMapper mapper = new ObjectMapper();
                    String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(form);
                    System.out.println(json);
                }

                // Close the Reader
                reader.close();

                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>("Error while processing file: " + e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        }
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
