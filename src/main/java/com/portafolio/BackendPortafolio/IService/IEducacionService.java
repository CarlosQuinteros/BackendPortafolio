package com.portafolio.BackendPortafolio.IService;

import com.portafolio.BackendPortafolio.Entity.Educacion;

import java.util.List;

public interface IEducacionService {
    public List<Educacion> listadoEducaciones();

    public Educacion crearEducacion(Educacion educacion);

    public Educacion editarEducacion(Long id, Educacion educacion);

    public void eliminarEducacion(Long id);

    public Educacion obtenerEducacion(Long id);

    public List<Educacion> listadoEducacionesPorPersona(Long idPersona);

}
