package com.portafolio.BackendPortafolio.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.portafolio.BackendPortafolio.Enum.TipoJornada;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class ExperienciaLaboral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String organizacion;

    private String urlImagen;

    @NotNull
    private String puesto;

    @NotNull
    private String tareas;

    @Enumerated(EnumType.STRING)
    private TipoJornada tipoJornada;

    @NotNull
    private LocalDate fechaDesde;

    private LocalDate fechaHasta;

    @NotNull
    @ManyToOne
    @JsonIgnore
    private Persona persona;

    @Transient
    private String duracion;

    @Transient
    private boolean trabajoActual;

    public ExperienciaLaboral(){}

    public ExperienciaLaboral(@NotNull String organizacion, String urlImagen ,@NotNull String puesto, @NotNull String tareas, TipoJornada tipoJornada, @NotNull LocalDate fechaDesde, LocalDate fechaHasta, @NotNull Persona persona) {
        this.organizacion = organizacion;
        this.urlImagen = urlImagen;
        this.puesto = puesto;
        this.tareas = tareas;
        this.tipoJornada = tipoJornada;
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

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTareas() {
        return tareas;
    }

    public void setTareas(String tareas) {
        this.tareas = tareas;
    }

    public TipoJornada getTipoJornada() {
        return tipoJornada;
    }

    public void setTipoJornada(TipoJornada tipoJornada) {
        this.tipoJornada = tipoJornada;
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

    public boolean isTrabajoActual() {
        return fechaHasta == null;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getDuracion() {
        LocalDate hasta = isTrabajoActual()? LocalDate.now() : fechaHasta;
        Period periodo = Period.between(this.fechaDesde, hasta);
        if(periodo.getYears() == 0 && periodo.getMonths()  == 0 && periodo.getDays() > 0) return periodo.getDays() + " dias";
        if(periodo.getYears() == 0 && periodo.getMonths() > 0 && periodo.getDays() > 0) return periodo.getMonths() + " meses y " + periodo.getDays() + " dias";
        if(periodo.getYears() == 0 && periodo.getMonths() > 0 && periodo.getDays() == 0) return periodo.getMonths()+ " meses";
        if(periodo.getYears() > 0 && periodo.getMonths() == 0 && periodo.getDays() == 0) return periodo.getYears() + " años";
        if(periodo.getYears() > 0 && periodo.getMonths() == 0 && periodo.getDays() > 0) return periodo.getYears() + " años y " + periodo.getDays() + " dias";
        if(periodo.getYears() > 0 && periodo.getMonths() > 0 && periodo.getDays() == 0) return periodo.getYears() + " años y " + periodo.getMonths()+ " meses";
        return periodo.getYears() + " años, " + periodo.getMonths() + " meses y " + periodo.getDays() + " dias";
    }
}
