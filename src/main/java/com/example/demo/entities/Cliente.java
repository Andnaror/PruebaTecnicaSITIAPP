package com.example.demo.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Integer tipo_identificacion;
    private String identificacion;
    private String razon_social;
    private Date fecha_registro;
    private String estado;

    protected Cliente(){}

    public Cliente(Integer tipo_identificacion, String identificacion, String razon_social, Date fecha_registro, String estado) {
        this.tipo_identificacion = tipo_identificacion;
        this.identificacion = identificacion;
        this.razon_social = razon_social;
        this.fecha_registro = fecha_registro;
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public Integer getTipo_identificacion() {
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
}
