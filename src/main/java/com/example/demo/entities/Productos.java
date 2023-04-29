package com.example.demo.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Productos {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer productoId;
    @Column(length = 100)
    private String nombre;
    @Column(length = 45)
    private String estado;
    private Integer valor_unitario;
    @OneToMany(mappedBy = "factura_detalleId.idProducto", cascade = CascadeType.ALL)
    private Set<Factura_detalle> factura_detalles;

    protected Productos(){}

    public Productos(String nombre, String estado, Integer valor_unitario) {
        this.nombre = nombre;
        this.estado = estado;
        this.valor_unitario = valor_unitario;
    }

    public Integer getId() {
        return productoId;
    }

    public void setId(Integer productoIdid) {
        this.productoId = productoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(Integer valor_unitario) {
        this.valor_unitario = valor_unitario;
    }
}
