package com.example.demo.controllers;


import com.example.demo.entities.Perfil;
import com.example.demo.entities.Usuario;
import com.example.demo.repository.PerfilRepository;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioRepository uRepository;
    @Autowired
    PerfilRepository pRepository;


    @GetMapping("/Usuarios")
    public ResponseEntity<List<Usuario>> getAllUsuarios(){
        List<Usuario> usuarios= uRepository.findAll();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/Usuario/{objectId}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable("objectId") Integer objectId){
        Usuario u = uRepository.findById(objectId).orElse(null);
        if (u!=null){
            return new ResponseEntity<>(u, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/Usuario")
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario nuevoUsuario){
        try{

            //Obtener el perfil del usuario a traves del ID de perfil
            Integer perfilId = nuevoUsuario.getId_perfil().getId_perfil();

            //Buscar la entidad TiposIdentificaciones correspondiente en la base de datos
            Perfil perfil = pRepository.findById(perfilId).orElse(null);
            if (perfil == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            //Asignar la entidad TiposIdentificaciones encontrada al campo tipo_identificacion del nuevo cliente
            nuevoUsuario.setId_perfil(perfil);

            Usuario u = uRepository.save(nuevoUsuario);
            return new ResponseEntity<>(u,HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
