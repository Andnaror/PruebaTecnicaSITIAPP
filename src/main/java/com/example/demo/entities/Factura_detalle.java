package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "factura_detalle")
public class Factura_detalle {
    @EmbeddedId
    private Factura_detalleId factura_detalleId;
    private Integer cantidad;
    private Integer valor_unitario;
    protected Factura_detalle(){}

    public Factura_detalle(Integer cantidad, Integer valor_unitario) {
        this.cantidad = cantidad;
        this.valor_unitario = valor_unitario;
    }
}
