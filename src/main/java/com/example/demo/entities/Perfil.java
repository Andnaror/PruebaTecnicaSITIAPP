package com.example.demo.entities;

import javax.persistence.*;

@Entity
//@Index(name = "Primary",columnList = "id_perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_perfil")
    private Integer id_perfil;

    @Column(length = 23)
    private String nombre;
    @OneToOne(mappedBy = "id_perfil")
    private Usuario usuario;
    protected Perfil(){}

    public Perfil(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId_perfil() {
        return id_perfil;
    }

    public String getNombre() {
        return nombre;
    }
}
