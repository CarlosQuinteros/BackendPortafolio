package com.portafolio.BackendPortafolio.Security.Dto;

import javax.validation.constraints.NotBlank;

public class LoginUsuario {

    @NotBlank(message = "El nombre de usuario no debe estar vacio")
    private String username;

    @NotBlank(message = "La contraseña no debe estar vacia")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
