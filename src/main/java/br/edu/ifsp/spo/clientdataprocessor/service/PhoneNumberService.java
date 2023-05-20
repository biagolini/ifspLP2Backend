package br.edu.ifsp.spo.clientdataprocessor.service;

import br.edu.ifsp.spo.clientdataprocessor.dto.PhoneNumberDto;
import br.edu.ifsp.spo.clientdataprocessor.dto.PhoneNumberForm;
import br.edu.ifsp.spo.clientdataprocessor.entity.PhoneNumber;
import br.edu.ifsp.spo.clientdataprocessor.entity.User;
import br.edu.ifsp.spo.clientdataprocessor.repository.PhoneNumberRepository;
import br.edu.ifsp.spo.clientdataprocessor.repository.UserRepository;
import br.edu.ifsp.spo.clientdataprocessor.repository.specifications.PhoneNumberSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PhoneNumberService  {

    private final PhoneNumberRepository phoneNumberRepository;

    private final UserRepository userRepository;

    public Page<PhoneNumber> findAll(Pageable pageable) {
        return this.phoneNumberRepository.findAll(PhoneNumberSpecification.isActive(), pageable);
    }

    public Page<PhoneNumber> findAll(Pageable pageable, String query, Long idPhoneNumberType, Long userId) {
        return this.phoneNumberRepository.findAll(PhoneNumberSpecification.likeGenericQuery(query,  idPhoneNumberType, userId), pageable);
    }

    public PhoneNumberDto findPhoneNumberById(Long id) {
        PhoneNumber phoneNumber = phoneNumberRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        PhoneNumberDto response = new PhoneNumberDto(phoneNumber);
        return  response;
    }

    public List<PhoneNumberDto> findPhoneNumberByUserId(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        List<PhoneNumber> phoneNumberList = phoneNumberRepository.findByUser(user);
        List<PhoneNumberDto> response = new ArrayList<>();
        for(PhoneNumber item: phoneNumberList){
            PhoneNumberDto newValue = new PhoneNumberDto(item);
            response.add(newValue);
        }
        return  response;
    }

    public void createPhoneNumber(PhoneNumberForm form) {
        User user = userRepository.findById(form.getUserId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        PhoneNumber newRegister = new PhoneNumber(user, form);
        phoneNumberRepository.save(newRegister);
    }

    public void inactivePhoneNumber(Long id) {
        PhoneNumber phoneNumber = phoneNumberRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        phoneNumber.setIsActive(false);
        phoneNumberRepository.save(phoneNumber);
    }

    public void updatePhoneNumber(Long id, PhoneNumberForm form) {
        User user = userRepository.findById(form.getUserId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        PhoneNumber phoneNumber = phoneNumberRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        phoneNumber.update(user, form);
        phoneNumberRepository.save(phoneNumber);
    }

}

