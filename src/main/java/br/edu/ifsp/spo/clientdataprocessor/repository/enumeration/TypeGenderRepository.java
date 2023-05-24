package br.edu.ifsp.spo.clientdataprocessor.repository.enumeration;

import br.edu.ifsp.spo.clientdataprocessor.entity.enumeration.TypeGender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeGenderRepository extends JpaRepository<TypeGender,Long>, JpaSpecificationExecutor<TypeGender> {
    @Query("SELECT a FROM TypeGender a WHERE LOWER(a.description) = LOWER(:description) AND a.isActive = true")
    Optional<TypeGender> findByDescription(String description);

}