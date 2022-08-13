package com.portafolio.BackendPortafolio.Service;

import com.portafolio.BackendPortafolio.Entity.ExperienciaLaboral;
import com.portafolio.BackendPortafolio.Enum.TipoJornada;
import com.portafolio.BackendPortafolio.Exception.ResourceNotFoundException;
import com.portafolio.BackendPortafolio.IService.IExperienciaLaboralService;
import com.portafolio.BackendPortafolio.Repository.ExperienciaLaboralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ExperienciaLaboralService implements IExperienciaLaboralService {

    @Autowired
    private ExperienciaLaboralRepository experienciaLaboralRepository;


    @Override
    public ExperienciaLaboral crearExperiencia(ExperienciaLaboral experienciaLaboral) {
        return experienciaLaboralRepository.save(experienciaLaboral);
    }

    @Override
    public ExperienciaLaboral editarExperiencia(Long id, ExperienciaLaboral experienciaLaboral) {
        ExperienciaLaboral experienciaLaboralAEditar = obtenerExperiencia(id);
        experienciaLaboralAEditar.setFechaDesde(experienciaLaboral.getFechaDesde());
        experienciaLaboralAEditar.setFechaHasta(experienciaLaboral.getFechaHasta());
        experienciaLaboralAEditar.setOrganizacion(experienciaLaboral.getOrganizacion());
        experienciaLaboralAEditar.setPuesto(experienciaLaboral.getPuesto());
        experienciaLaboralAEditar.setTareas(experienciaLaboral.getTareas());
        experienciaLaboralAEditar.setTipoJornada(experienciaLaboral.getTipoJornada());
        experienciaLaboralAEditar.setUrlImagen(experienciaLaboral.getUrlImagen());
        return experienciaLaboralRepository.save(experienciaLaboralAEditar);
    }

    @Override
    public List<ExperienciaLaboral> listadoExperiencias() {
        return experienciaLaboralRepository.findAll();
    }

    @Override
    public ExperienciaLaboral obtenerExperiencia(Long id) {
        return experienciaLaboralRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe la experiencia con id: " + id));
    }

    @Override
    public void eliminarExperiencia(Long id) {
        experienciaLaboralRepository.deleteById(id);
    }

    @Override
    public List<String> listadoTiposDeJornada() {
        return Arrays.stream(TipoJornada.values())
                .map(tipoJornada -> tipoJornada.name())
                .collect(Collectors.toList());
    }

    @Override
    public TipoJornada obtenerTipoJornadaPorNombre(String tipoJornada) {
        return Arrays.stream(TipoJornada.values())
                .filter(tipo -> tipo.name().equals(tipoJornada))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("No existe el tipo de jornada: " + tipoJornada));
    }

    @Override
    public List<ExperienciaLaboral> listadoExperienciasPorPersona(Long idPersona) {
        return experienciaLaboralRepository.findByPersona_Id(idPersona);
    }
}
