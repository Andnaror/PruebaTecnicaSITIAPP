package com.example.demo.controllers;

import com.example.demo.entities.Cliente;
import com.example.demo.entities.TiposIdentificaciones;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.TiposIdentificacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository cRepository;
    @Autowired
    TiposIdentificacionesRepository tRepository;


    @GetMapping("/Clientes")
    public ResponseEntity<List<Cliente>> getAllClientes(){
        List<Cliente> clientes= cRepository.findAll();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/Cliente/{objectId}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable("objectId") Integer objectId){
        Cliente c = cRepository.findById(objectId).get();
        if (c!=null){
            return new ResponseEntity<>(c, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/Cliente")
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente nuevoCliente){
        try{
            //Se le asigna la fecha actual
            LocalDate fechaActual = LocalDate.now();
            ZoneId zoneId = ZoneId.systemDefault();
            nuevoCliente.setFecha_registro(Date.from(fechaActual.atStartOfDay(zoneId).toInstant()));

            //Obtener el tipo de identificación del cliente a través de su ID
            Integer tipoIdentificacionId = nuevoCliente.getTipo_identificacion().getTipo_identificacion();

            //Buscar la entidad TiposIdentificaciones correspondiente en la base de datos
            TiposIdentificaciones tipoIdentificacion = tRepository.findById(tipoIdentificacionId).orElse(null);
            if (tipoIdentificacion == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            //Asignar la entidad TiposIdentificaciones encontrada al campo tipo_identificacion del nuevo cliente
            nuevoCliente.setTipo_identificacion(tipoIdentificacion);

            Cliente c = cRepository.save(nuevoCliente);
            return new ResponseEntity<>(c,HttpStatus.CREATED);
        }catch (Exception e){

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
