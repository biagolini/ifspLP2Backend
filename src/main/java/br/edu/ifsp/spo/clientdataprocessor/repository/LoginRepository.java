package br.edu.ifsp.spo.clientdataprocessor.repository;


import br.edu.ifsp.spo.clientdataprocessor.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login,Long>, JpaSpecificationExecutor<Login> {


}
