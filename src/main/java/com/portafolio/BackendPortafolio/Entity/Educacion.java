package com.portafolio.BackendPortafolio.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String institucion;

    private String urlImagen;

    @NotNull
    private String titulo;

    @NotNull
    private LocalDate fechaDesde;

    private LocalDate fechaHasta;

    @NotNull
    @ManyToOne
    @JsonIgnore
    private Persona persona;

    public Educacion(){}

    public Educacion(@NotNull String institucion, String urlImagen, @NotNull String titulo, @NotNull LocalDate fechaDesde, LocalDate fechaHasta, @NotNull Persona persona) {
        this.institucion = institucion;
        this.urlImagen = urlImagen;
        this.titulo = titulo;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.persona = persona;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(LocalDate fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public LocalDate getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(LocalDate fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
