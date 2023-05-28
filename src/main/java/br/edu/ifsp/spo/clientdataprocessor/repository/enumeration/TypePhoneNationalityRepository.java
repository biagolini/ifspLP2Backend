package br.edu.ifsp.spo.clientdataprocessor.repository.enumeration;

import br.edu.ifsp.spo.clientdataprocessor.entity.enumeration.TypePhoneNationality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypePhoneNationalityRepository extends JpaRepository<TypePhoneNationality,Long>, JpaSpecificationExecutor<TypePhoneNationality> {

    @Query("SELECT a FROM TypePhoneNationality a WHERE LOWER(a.countryAbbreviation) = LOWER(:description) AND a.isActive = true")
    Optional<TypePhoneNationality> findByCountryAbbreviation(String description);

    @Query("SELECT a FROM TypePhoneNationality a WHERE LOWER(a.countryDescription) = LOWER(:description) AND a.isActive = true")
    Optional<TypePhoneNationality> findByCountryDescription(String description);

    @Query("SELECT a FROM TypePhoneNationality a WHERE LOWER(a.code) = LOWER(:description) AND a.isActive = true")
    Optional<TypePhoneNationality> findByCode(String description);

}