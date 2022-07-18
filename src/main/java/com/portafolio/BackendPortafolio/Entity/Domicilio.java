package com.portafolio.BackendPortafolio.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String calle;

    @NotNull
    private Integer numero;

    @NotNull
    private String Localidad;

    public Domicilio(){}

    public Domicilio(@NotNull String calle, @NotNull Integer numero, @NotNull String localidad) {
        this.calle = calle;
        this.numero = numero;
        Localidad = localidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String localidad) {
        Localidad = localidad;
    }
}
