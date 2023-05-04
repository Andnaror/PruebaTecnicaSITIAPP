package com.example.demo.entities;


import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer consecutivo;
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private Cliente cliente;

    @Column
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @OneToMany(mappedBy = "factura_detalleId.consecutivo",cascade = CascadeType.ALL)
    private List<Factura_detalle> factura_detalles;
    protected Factura(){}

    public Factura(Cliente cliente, Date fecha) {
        this.cliente = cliente;
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Factura_detalle> getFactura_detalles() {
        return factura_detalles;
    }

    public Integer getConsecutivo() {
        return consecutivo;
    }
}
