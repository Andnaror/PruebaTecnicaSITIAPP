package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class Factura_detalleId implements Serializable{
    private static final long serialVersionUID = 1L;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "consecutivo")
    private Factura consecutivo;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Productos idProducto;

    public Factura getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Factura consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }
}
