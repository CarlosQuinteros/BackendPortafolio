package com.portafolio.BackendPortafolio.Security.Entity;

import com.portafolio.BackendPortafolio.Security.Enum.Rol;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String userName;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    public Usuario(){}

    public Usuario(@NotNull String userName, @NotNull String email, @NotNull String password, Rol rol) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
