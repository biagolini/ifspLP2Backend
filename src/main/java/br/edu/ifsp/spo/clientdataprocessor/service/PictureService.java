package br.edu.ifsp.spo.clientdataprocessor.service;

import br.edu.ifsp.spo.clientdataprocessor.entity.Picture;
import br.edu.ifsp.spo.clientdataprocessor.repository.PictureRepository;
import br.edu.ifsp.spo.clientdataprocessor.repository.specifications.PictureSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PictureService {
    private final PictureRepository pictureRepository;

    public Page<Picture> findAll(Pageable pageable) {
        return this.pictureRepository.findAll(PictureSpecification.isActive(), pageable);
    }

    public Page<Picture> findAll(Pageable pageable, String query, Long userId) {
        return this.pictureRepository.findAll(PictureSpecification.likeGenericQuery(query,  userId), pageable);
    }

}
