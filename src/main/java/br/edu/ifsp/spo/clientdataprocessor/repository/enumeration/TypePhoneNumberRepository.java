package br.edu.ifsp.spo.clientdataprocessor.repository.enumeration;

import br.edu.ifsp.spo.clientdataprocessor.entity.enumeration.TypePhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypePhoneNumberRepository extends JpaRepository<TypePhoneNumber,Long>, JpaSpecificationExecutor<TypePhoneNumber> {

    @Query("SELECT a FROM TypePhoneNumber a WHERE LOWER(a.description) = LOWER(:description) AND a.isActive = true")
    Optional<TypePhoneNumber> findByDescription(String description);

}