package com.example.demo.controllers;

import com.example.demo.entities.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository cRepository;

    @GetMapping("/Clientes")
    public ResponseEntity<List<Cliente>> getAllClientes(){
        List<Cliente> clientes= cRepository.findAll();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/Cliente/{objectId}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable("objectId") Long objectId){
        Cliente c = cRepository.findById(objectId).get();
        if (c!=null){
            return new ResponseEntity<>(c, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/Cliente")
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente){
        try{
            Cliente c = cRepository.save(cliente);
            return new ResponseEntity<>(c,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
