package com.portafolio.BackendPortafolio.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class EducacionDto {

    @NotNull(message = "El idPersona es obligatorio")
    private Long idPersona;

    @NotBlank(message = "La institucion es obligatoria")
    private String institucion;

    private String urlImagen;

    @NotBlank(message = "El titulo es obligatorio")
    private String titulo;

    @NotBlank(message = "La fecha desde es obligatoria")
    @JsonFormat(pattern="yyyy-MM-dd")
    private String fechaDesde;

    @NotBlank(message = "La fecha hasta es obligatoria")
    @JsonFormat(pattern="yyyy-MM-dd")
    private String fechaHasta;

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
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
        return LocalDate.parse(fechaDesde);
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public LocalDate getFechaHasta() {
        return (fechaHasta == null) ? null : LocalDate.parse(fechaHasta);
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }
}
