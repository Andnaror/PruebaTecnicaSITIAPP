package com.example.demo.entities;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
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

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
}
}