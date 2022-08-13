package com.portafolio.BackendPortafolio.IService;

import com.portafolio.BackendPortafolio.Entity.Habilidad;

import java.util.List;

public interface IHabilidadService {

    public Habilidad crearHabilidad(Habilidad habilidad);

    public Habilidad editarHabilidad(Long id, Habilidad habilidad);

    public List<Habilidad> listadoHabilidades();

    public Habilidad obtenerHabilidad(Long id);

    public void eliminarHabilidad(Long id);

    public List<Habilidad> listadoHabilidadesPorPersona(Long idPersona);
}
