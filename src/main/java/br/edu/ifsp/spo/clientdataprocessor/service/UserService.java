package br.edu.ifsp.spo.clientdataprocessor.service;

import br.edu.ifsp.spo.clientdataprocessor.entity.User;
import br.edu.ifsp.spo.clientdataprocessor.repository.UserRepository;
import br.edu.ifsp.spo.clientdataprocessor.repository.specifications.UserSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;


    public Page<User> findAll(Pageable pageable) {
        return this.userRepository.findAll(UserSpecification.isActive(), pageable);
    }

    public Page<User> findAll(Pageable pageable, String query, Long idLocationType, Long idRegionType, Double latitudeMax, Double latitudeMin, Double longitudeMax, Double longitudeMin) {
        return this.userRepository.findAll(UserSpecification.likeGenericQuery(query,  idLocationType, idRegionType,  latitudeMax,  latitudeMin,  longitudeMax,  longitudeMin), pageable);
    }
}
