package com.example.demo.repository;

import com.example.demo.entities.TiposIdentificaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;



@Transactional
public interface TiposIdentificacionesRepository extends JpaRepository<TiposIdentificaciones,Integer> {

}
