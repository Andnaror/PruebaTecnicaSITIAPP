package com.example.demo.repository;

import com.example.demo.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

//import java.util.List;

@Transactional
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    //List<Cliente> findByObjectId(Long idCliente);
}
