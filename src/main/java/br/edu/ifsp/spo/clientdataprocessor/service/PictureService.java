package br.edu.ifsp.spo.clientdataprocessor.service;

import br.edu.ifsp.spo.clientdataprocessor.dto.PhoneNumberDto;
import br.edu.ifsp.spo.clientdataprocessor.dto.PictureDto;
import br.edu.ifsp.spo.clientdataprocessor.dto.PictureForm;
import br.edu.ifsp.spo.clientdataprocessor.entity.PhoneNumber;
import br.edu.ifsp.spo.clientdataprocessor.entity.Picture;
import br.edu.ifsp.spo.clientdataprocessor.entity.User;
import br.edu.ifsp.spo.clientdataprocessor.repository.PictureRepository;
import br.edu.ifsp.spo.clientdataprocessor.repository.UserRepository;
import br.edu.ifsp.spo.clientdataprocessor.repository.specifications.PictureSpecification;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class PictureService {

    private final PictureRepository pictureRepository;

    private final UserRepository userRepository;

    public Page<Picture> findAll(Pageable pageable) {
        return this.pictureRepository.findAll(PictureSpecification.isActive(), pageable);
    }

    public Page<Picture> findAll(Pageable pageable, String query, Long userId) {
        return this.pictureRepository.findAll(PictureSpecification.likeGenericQuery(query,  userId), pageable);
    }


    public PictureDto findPictureById(Long id) {
        Picture picture = pictureRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        PictureDto response = new PictureDto(picture);
        return  response;
    }
    public PictureDto findPictureByUserId(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        List<Picture> pictureList = pictureRepository.findByUser(user);
        PictureDto response = new PictureDto();
        if (!pictureList.isEmpty()) {
            Picture lastPicture = pictureList.get(pictureList.size() - 1);
            response.update(lastPicture);
        }
        return  response;
    }


    public void createPicture(PictureForm form) {
        User user = userRepository.findById(form.getUserId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        Picture newRegister = new Picture(user, form);
        pictureRepository.save(newRegister);
    }

    public void inactivePicture(Long id) {
        Picture picture = pictureRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        picture.setIsActive(false);
        pictureRepository.save(picture);
    }

    public void updatePicture(Long id, PictureForm form) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        Picture picture = pictureRepository.findById(user.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        picture.update(user, form);
        pictureRepository.save(picture);
    }


}
