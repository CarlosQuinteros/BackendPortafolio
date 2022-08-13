package com.portafolio.BackendPortafolio.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProyectoDto {

    @NotNull(message = "El idPersona es obligatorio")
    private Long idPersona;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "La descripcion es obligatorio")
    private String descripcion;

    @NotBlank(message = "La url es obligatoria")
    private String urlRepositorio;


    public Long getIdPersona() {
        return idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUrlRepositorio() {
        return urlRepositorio;
    }
}
