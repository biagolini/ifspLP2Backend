package br.edu.ifsp.spo.clientdataprocessor.service;

import br.edu.ifsp.spo.clientdataprocessor.entity.PhoneNumber;
import br.edu.ifsp.spo.clientdataprocessor.repository.PhoneNumberRepository;
import br.edu.ifsp.spo.clientdataprocessor.repository.specifications.PhoneNumberSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PhoneNumberService  {

    private final PhoneNumberRepository phoneNumberRepository;

    public Page<PhoneNumber> findAll(Pageable pageable) {
        return this.phoneNumberRepository.findAll(PhoneNumberSpecification.isActive(), pageable);
    }

    public Page<PhoneNumber> findAll(Pageable pageable, String query, Long idPhoneNumberType, Long userId) {
        return this.phoneNumberRepository.findAll(PhoneNumberSpecification.likeGenericQuery(query,  idPhoneNumberType, userId), pageable);
    }

}
