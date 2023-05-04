package com.example.demo.entities;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 45)
    private String firstName;
    @Column(nullable = true, length = 45)
    private String lastName;
    @Column(nullable = false, length = 45)
    private String usuario;

    @Column(nullable = false, length = 45)
    private String contrasena;
    @OneToOne
    @JoinColumn(name = "id_perfil")
    private Perfil id_perfil;

    protected Usuario() {}

    public Usuario(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
}

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public Perfil getId_perfil() {
        return id_perfil;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setId_perfil(Perfil id_perfil) {
        this.id_perfil = id_perfil;
    }
}