package com.example.demo.repository;

import com.example.demo.entities.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PerfilRepository extends JpaRepository<Perfil,Integer> {
}
