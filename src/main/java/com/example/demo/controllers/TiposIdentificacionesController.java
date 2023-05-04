package com.example.demo.controllers;


import com.example.demo.entities.TiposIdentificaciones;
import com.example.demo.repository.TiposIdentificacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TiposIdentificacionesController {

    @Autowired
    private TiposIdentificacionesRepository tIRepository;

    @GetMapping("/TiposIdentificaciones")
    public ResponseEntity<List<TiposIdentificaciones>> getAllTiposIdentificacion(){
        List<TiposIdentificaciones> tiposIdentificaciones= tIRepository.findAll();
        return new ResponseEntity<>(tiposIdentificaciones, HttpStatus.OK);
    }

    @GetMapping("/TiposIdentificacion/{objectId}")
    public ResponseEntity<TiposIdentificaciones> getTipoIdentificacionById(@PathVariable("objectId") Integer objectId){
        TiposIdentificaciones tI = tIRepository.findById(objectId).orElseThrow(null);
        try {
            if (tI != null) {
                return new ResponseEntity<>(tI, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/TiposIdentificacion")
    public ResponseEntity<TiposIdentificaciones> createTipoIdentificacion(@RequestBody TiposIdentificaciones tI){
        try{
            TiposIdentificaciones tId = tIRepository.save(tI);
            return new ResponseEntity<>(tId,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
