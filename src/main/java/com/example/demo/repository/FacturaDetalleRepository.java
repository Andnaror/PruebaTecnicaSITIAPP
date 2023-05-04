package com.example.demo.repository;

import com.example.demo.entities.Factura_detalle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacturaDetalleRepository extends JpaRepository<Factura_detalle, Integer> {
    //List<Factura_detalle> findAllByFacturaConsecutivo(Integer consecutivo);
}
