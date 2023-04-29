package com.example.demo.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="tipo_identificacion")
    private Tipos_identificaciones tipo_identificacion;
    @Column(length = 100)
    private String identificacion;
    @Column(length = 100)
    private String razon_social;
    @Column
    private Date fecha_registro;
    @Column(length = 1)
    private String estado;

    protected Cliente(){}

    public Cliente(Tipos_identificaciones tipo_identificacion, String identificacion, String razon_social, Date fecha_registro, String estado) {
        this.tipo_identificacion = tipo_identificacion;
        this.identificacion = identificacion;
        this.razon_social = razon_social;
        this.fecha_registro = fecha_registro;
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public Tipos_identificaciones getTipo_identificacion() {
        return tipo_identificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public String getEstado() {
        return estado;
    }

    public void setTipo_identificacion(Tipos_identificaciones tipo_identificacion) {
        this.tipo_identificacion = tipo_identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
