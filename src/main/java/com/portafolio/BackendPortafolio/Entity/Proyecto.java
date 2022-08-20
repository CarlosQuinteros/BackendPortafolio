package com.portafolio.BackendPortafolio.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nombre;

    @NotNull
    private String descripcion;

    @NotNull
    private String urlRepositorio;

    @NotNull
    @ManyToOne
    @JsonIgnore
    private Persona persona;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "proyecto")
    private List<ImagenProyecto> imagenes;

    public Proyecto(){}

    public Proyecto(@NotNull String nombre, @NotNull String descripcion, @NotNull String urlRepositorio, @NotNull Persona persona) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlRepositorio = urlRepositorio;
        this.persona = persona;
        this.imagenes = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlRepositorio() {
        return urlRepositorio;
    }

    public void setUrlRepositorio(String urlRepositorio) {
        this.urlRepositorio = urlRepositorio;
    }

    public Persona getPersona() {
        return persona;
    }

    public List<ImagenProyecto> getImagenes() {
        return imagenes;
    }
}
