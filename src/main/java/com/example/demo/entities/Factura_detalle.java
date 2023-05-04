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

    public Factura_detalleId getFactura_detalleId() {
        return factura_detalleId;
    }

    public void setFactura_detalleId(Factura_detalleId factura_detalleId) {
        this.factura_detalleId = factura_detalleId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(Integer valor_unitario) {
        this.valor_unitario = valor_unitario;
    }
}
