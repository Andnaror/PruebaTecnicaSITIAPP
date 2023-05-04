package com.example.demo.controllers;

import com.example.demo.entities.Productos;
import com.example.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {
    @Autowired
    private ProductoRepository pRepository;



    @GetMapping("/Productos")
    public ResponseEntity<List<Productos>> getAllProductos(){
        List<Productos> productos= pRepository.findAll();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/Producto/{objectId}")
    public ResponseEntity<Productos> getProductoById(@PathVariable("objectId") Integer objectId){
        Productos p = pRepository.findById(objectId).get();
        if (p!=null){
            return new ResponseEntity<>(p, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/Producto")
    public ResponseEntity<Productos> createProducto(@RequestBody Productos nuevoCliente){
        try{

            Productos c = pRepository.save(nuevoCliente);
            return new ResponseEntity<>(c,HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
