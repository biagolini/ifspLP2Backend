package br.edu.ifsp.spo.clientdataprocessor.repository.enumeration;

import br.edu.ifsp.spo.clientdataprocessor.entity.enumeration.TypeLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeLocationRepository extends JpaRepository<TypeLocation,Long>, JpaSpecificationExecutor<TypeLocation> {

    @Query("SELECT a FROM TypeLocation a WHERE LOWER(a.description) = LOWER(:description) AND a.isActive = true")
    Optional<TypeLocation> findByDescription(String description);


}