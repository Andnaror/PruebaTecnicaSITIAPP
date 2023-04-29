package com.example.demo.entities;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class Factura_detalleId implements Serializable{
    private static final long serialVersionUID = 1L;
        @ManyToOne
        @JoinColumn(name = "consecutivo")
        private Factura consecutivo;
        @ManyToOne
        @JoinColumn(name = "idProducto")
        private Productos idProducto;
}
