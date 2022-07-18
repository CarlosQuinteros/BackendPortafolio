package com.portafolio.BackendPortafolio.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String descripcion;

    @NotNull
    private String urlImagen;

    @NotNull
    private Integer porcentaje;

    @NotNull
    @ManyToOne
    private Persona persona;

    public  Habilidad(){}

    public Habilidad(@NotNull String descripcion, @NotNull String urlImagen, @NotNull Integer porcentaje, @NotNull Persona persona) {
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.porcentaje = porcentaje;
        this.persona = persona;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
