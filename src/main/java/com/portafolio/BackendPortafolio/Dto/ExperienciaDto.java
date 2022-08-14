package com.portafolio.BackendPortafolio.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ExperienciaDto {

    @NotNull(message = "El idPersona es obligatorio")
    private Long idPersona;

    @NotBlank(message = "La organizacion es obligatoria")
    private String organizacion;

    private String urlImagen;

    @NotBlank(message = "El puesto es obligatorio")
    private String puesto;

    @NotBlank(message = "La descripcion de tares es obligatoria")
    private String tareas;

    @NotBlank(message = "El tipo de jornada es obligatoria")
    private String tipoJornada;

    @NotBlank(message = "La fecha desde es obligatoria")
    @JsonFormat(pattern="yyyy-MM-dd")
    private String fechaDesde;

    //@NotBlank(message = "La fecha hasta es obligatoria")
    @JsonFormat(pattern="yyyy-MM-dd")
    private String fechaHasta;

    public Long getIdPersona() {
        return idPersona;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public String getPuesto() {
        return puesto;
    }

    public String getTareas() {
        return tareas;
    }

    public String getTipoJornada() {
        return tipoJornada;
    }

    public LocalDate getFechaDesde() {
        return LocalDate.parse(fechaDesde);
    }

    public LocalDate getFechaHasta() {
        return (fechaHasta == null) ? null : LocalDate.parse(fechaHasta);
    }
}
