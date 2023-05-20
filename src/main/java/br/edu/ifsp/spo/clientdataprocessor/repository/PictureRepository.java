package br.edu.ifsp.spo.clientdataprocessor.repository;

import br.edu.ifsp.spo.clientdataprocessor.entity.Picture;
import br.edu.ifsp.spo.clientdataprocessor.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long>, JpaSpecificationExecutor<Picture> {
    @Query("SELECT a FROM Picture a WHERE a.user = :user AND a.isActive = true")
    List<Picture> findByUser(User user);

}
