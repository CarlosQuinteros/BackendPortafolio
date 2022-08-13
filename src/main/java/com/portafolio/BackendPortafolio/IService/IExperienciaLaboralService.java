package com.portafolio.BackendPortafolio.IService;

import com.portafolio.BackendPortafolio.Entity.ExperienciaLaboral;
import com.portafolio.BackendPortafolio.Enum.TipoJornada;

import java.util.List;

public interface IExperienciaLaboralService {

    public ExperienciaLaboral crearExperiencia(ExperienciaLaboral experienciaLaboral);

    public ExperienciaLaboral editarExperiencia(Long id, ExperienciaLaboral experienciaLaboral);

    public List<ExperienciaLaboral> listadoExperiencias();

    public ExperienciaLaboral obtenerExperiencia(Long id);

    public void eliminarExperiencia(Long id);

    public List<String> listadoTiposDeJornada();

    public TipoJornada obtenerTipoJornadaPorNombre(String tipoJornada);

    public List<ExperienciaLaboral> listadoExperienciasPorPersona(Long idPersona);
}
