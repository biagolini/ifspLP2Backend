package br.edu.ifsp.spo.clientdataprocessor.service;

import br.edu.ifsp.spo.clientdataprocessor.dto.UserDto;
import br.edu.ifsp.spo.clientdataprocessor.dto.UserForm;
import br.edu.ifsp.spo.clientdataprocessor.entity.User;
import br.edu.ifsp.spo.clientdataprocessor.repository.UserRepository;
import br.edu.ifsp.spo.clientdataprocessor.repository.specifications.UserSpecification;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

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

    public UserDto findUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        UserDto response = new UserDto(user);
        return  response;
    }

    public void createUser(UserForm form) {
        Optional<User> conflictTestEmail = userRepository.findByEmail(form.getEmail());
        if(conflictTestEmail.isPresent() ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        User newRegister = new User(form);
        userRepository.save(newRegister);
    }

    public void inactiveUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        user.setIsActive(false);
        userRepository.save(user);
    }

    public void updateUser(Long id, UserForm form) {
        Optional <User> conflict = userRepository.findConflict(form.getEmail(),id);
        if(conflict.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        User user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        user.update(form);
        userRepository.save(user);
    }


}
