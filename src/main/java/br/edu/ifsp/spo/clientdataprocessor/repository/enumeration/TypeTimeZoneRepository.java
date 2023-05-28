package br.edu.ifsp.spo.clientdataprocessor.repository.enumeration;

import br.edu.ifsp.spo.clientdataprocessor.entity.enumeration.TypeTimeZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeTimeZoneRepository extends JpaRepository<TypeTimeZone,Long>, JpaSpecificationExecutor<TypeTimeZone> {

    @Query("SELECT a FROM TypeTimeZone a WHERE LOWER(a.timezoneOffset) = LOWER(:timezoneOffset)  AND a.isActive = true")
    Optional<TypeTimeZone> findByTimeZoneOffset (String timezoneOffset);

    @Query("SELECT a FROM TypeTimeZone a WHERE LOWER(a.timezoneDescription) = LOWER(:timezoneDescription)  AND a.isActive = true")
    Optional<TypeTimeZone> findByTimezoneDescription (String timezoneDescription);

    @Query("SELECT a FROM TypeTimeZone a WHERE (LOWER(a.timezoneOffset) = LOWER(:timezoneOffset) OR LOWER(a.timezoneDescription) = LOWER(:timezoneDescription)) AND a.isActive = true")
    Optional<TypeTimeZone> findByDescriptionOrOffset(String timezoneOffset, String timezoneDescription);


}