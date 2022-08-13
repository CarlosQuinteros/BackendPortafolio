package com.portafolio.BackendPortafolio.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class ImagenProyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String url;

    @NotNull
    private String descripcion;

    @JsonIgnore
    @ManyToOne
    private Proyecto proyecto;

    public ImagenProyecto(){}

    public ImagenProyecto(@NotNull String url, @NotNull String descripcion, @NotNull Proyecto proyecto) {
        this.url = url;
        this.descripcion = descripcion;
        this.proyecto = proyecto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
}
