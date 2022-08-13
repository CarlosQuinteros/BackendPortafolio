package com.portafolio.BackendPortafolio.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ImagenProyectoDto {

    @NotBlank(message = "La url es obligatorio")
    private String url;

    @NotBlank(message = "La descripcion es obligatoria")
    private String descripcion;

    @NotNull(message = "El proyecto es obligatorio")
    private Long idProyecto;

    public Long getIdProyecto() {
        return idProyecto;
    }

    public String getUrl() {
        return url;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
