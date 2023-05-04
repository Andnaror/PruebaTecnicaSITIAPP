package com.example.demo.repository;

import com.example.demo.entities.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ProductoRepository extends JpaRepository<Productos,Integer> {
}
