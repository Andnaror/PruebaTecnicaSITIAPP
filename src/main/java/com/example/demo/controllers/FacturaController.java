package com.example.demo.controllers;

import com.example.demo.entities.Cliente;
import com.example.demo.entities.Factura;
import com.example.demo.entities.Factura_detalle;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;



@RestController
public class FacturaController {
    @Autowired
    FacturaRepository fRepository;
    @Autowired
    ProductoRepository pRepository;
    @Autowired
    FacturaDetalleRepository fDRepository;
   
   
    @Autowired
    ClienteRepository cRepository;
    @GetMapping("/Facturas")
    public ResponseEntity<List<Factura>> getAllTiposIdentificacion(){
        List<Factura> facturas = fRepository.findAll();
        return new ResponseEntity<>(facturas, HttpStatus.OK);
    }

    @GetMapping("/Factura/{objectId}")
    public ResponseEntity<Factura> getFactura(@PathVariable ("objectId") Integer objectId){
        try{
            Factura f = fRepository.findById(objectId).orElseThrow(null);
            if(f!=null){
                return new ResponseEntity<>(f, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/Factura")
    public ResponseEntity<Factura> createFactura(@RequestBody Factura nuevaFactura){
        try {


            //Se le asigna la fecha actual
            LocalDate fechaActual = LocalDate.now();
            ZoneId zoneId = ZoneId.systemDefault();
            nuevaFactura.setFecha(Date.from(fechaActual.atStartOfDay(zoneId).toInstant()));

            Integer clienteID = nuevaFactura.getCliente().getId();
            Cliente cliente = cRepository.findById(clienteID).orElseThrow(null);
            if (cliente == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            nuevaFactura.setCliente(cliente);

           


            //Factura creada
            Factura f = fRepository.save(nuevaFactura);

            return  new ResponseEntity<>(f, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
