package com.portafolio.BackendPortafolio.Dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class HabilidadDto {


    @NotNull(message = "El idPersona es obligatorio")
    private Long idPersona;

    @NotBlank(message = "La descripcion es obligatoria")
    private String descripcion;

    private String urlImagen;

    @NotNull(message = "El porcentaje es obligatorio")
    private Integer porcentaje;

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
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
}
