package br.edu.ifsp.spo.clientdataprocessor.repository;

import br.edu.ifsp.spo.clientdataprocessor.entity.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber,Long>, JpaSpecificationExecutor<PhoneNumber> {
}
