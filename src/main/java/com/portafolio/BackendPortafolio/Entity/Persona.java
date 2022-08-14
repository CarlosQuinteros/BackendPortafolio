package com.portafolio.BackendPortafolio.Entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nombres;

    @NotNull
    private String apellido;

    @NotNull
    private String documento;

    @NotNull
    private LocalDate fechaNacimiento;

    private String acercaDe;

    private String urlImagen;

    private String correo;

    private String urlCurriculum;

    private String telefono;

    @Transient
    private Integer edad;

    @OneToOne(cascade = CascadeType.ALL)
    private Domicilio domicilio;


    public Persona(){}

    public Persona(@NotNull String nombres, @NotNull String apellido, @NotNull String documento, @NotNull LocalDate fechaNacimiento, String acercaDe, String urlImagen, String correo, String urlCurriculum, String telefono, Domicilio domicilio) {
        this.nombres = nombres;
        this.apellido = apellido;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
        this.acercaDe = acercaDe;
        this.urlImagen = urlImagen;
        this.correo = correo;
        this.urlCurriculum = urlCurriculum;
        this.telefono = telefono;
        this.domicilio = domicilio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Integer getEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
}
