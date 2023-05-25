package br.edu.ifsp.spo.clientdataprocessor.repository.enumeration;

import br.edu.ifsp.spo.clientdataprocessor.entity.enumeration.TypeGender;
import br.edu.ifsp.spo.clientdataprocessor.entity.enumeration.TypeState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeStateRepository extends JpaRepository<TypeState,Long>, JpaSpecificationExecutor<TypeState> {
    @Query("SELECT a FROM TypeState a WHERE (LOWER(a.description) = LOWER(:data) OR LOWER(a.abbreviation) = LOWER(:data) ) AND a.isActive = true")
    Optional<TypeState> findByDescription(String data);


}
