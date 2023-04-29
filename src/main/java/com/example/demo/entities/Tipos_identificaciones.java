package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Tipos_identificaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tipo_identificacion;
    @Column(length = 3)
    private String abreviatura;
    @Column(length = 100)
    private String descripcion;
    @JsonIgnore
    @OneToMany(mappedBy = "tipo_identificacion")
    private Set<Cliente> clientes;



    protected Tipos_identificaciones(){}

    public Tipos_identificaciones(Integer tipo_identificacion, String abreviatura, String descripcion){
        this.tipo_identificacion = tipo_identificacion;
        this.abreviatura = abreviatura;
        this.descripcion = descripcion;
    }

    public Integer getTipo_identificacion() {
        return tipo_identificacion;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }
}
