package com.portafolio.BackendPortafolio.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

public class PersonaDto {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @NotBlank(message = "El documento es obligatorio")
    private String documento;

    @NotBlank(message = "El correo es obligatorio")
    private String correo;

    @NotBlank(message = "La fecha es obligatoria")
    @JsonFormat(pattern="yyyy-MM-dd")
    private String fechaNacimiento;

    @NotBlank(message = "Acerca de es obligatorio")
    private String acercaDe;

    @NotBlank(message = "La imagen es obligatoria")
    private String urlImagen;

    @NotBlank(message = "La url del curriculum es obligatoria")
    private String urlCurriculum;

    @NotBlank(message = "El telefono es obligatorio")
    private String telefono;

    @NotBlank(message = "La calle del domicio es obligatorio")
    private String calle;

    @NotNull(message = "El numero del domicio es obligatorio")
    private Integer numero;

    @NotBlank(message = "La localidad es obligatoria")
    private String localidad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getFechaNacimiento() {
        return LocalDate.parse(fechaNacimiento);
    }

    public String getAcercaDe() {
        return acercaDe;
    }

    public void setAcercaDe(String acercaDe) {
        this.acercaDe = acercaDe;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getUrlCurriculum() {
        return urlCurriculum;
    }

    public void setUrlCurriculum(String urlCurriculum) {
        this.urlCurriculum = urlCurriculum;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}
