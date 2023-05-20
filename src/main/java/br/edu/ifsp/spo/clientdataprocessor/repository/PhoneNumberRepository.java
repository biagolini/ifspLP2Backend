package br.edu.ifsp.spo.clientdataprocessor.repository;

import br.edu.ifsp.spo.clientdataprocessor.entity.PhoneNumber;
import br.edu.ifsp.spo.clientdataprocessor.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber,Long>, JpaSpecificationExecutor<PhoneNumber> {
    @Query("SELECT a FROM PhoneNumber a WHERE a.user = :user AND a.isActive = true")
    List<PhoneNumber> findByUser(User user);
}
