package com.portafolio.BackendPortafolio.IService;

import com.portafolio.BackendPortafolio.Entity.Proyecto;

import java.util.List;

public interface IProyectoService {

    public Proyecto crearProyecto(Proyecto proyecto);

    public Proyecto editarProyecto(Long id, Proyecto proyecto);

    public Proyecto obtenerProyecto(Long id);

    public List<Proyecto> listadoProyectos();

    public List<Proyecto> listadoProyectosPorPersona(Long idPersona);

    public void eliminarProyecto(Long id);
}
