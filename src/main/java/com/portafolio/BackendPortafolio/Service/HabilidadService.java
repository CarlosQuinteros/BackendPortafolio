package com.portafolio.BackendPortafolio.Service;

import com.portafolio.BackendPortafolio.Entity.Habilidad;
import com.portafolio.BackendPortafolio.Exception.ResourceNotFoundException;
import com.portafolio.BackendPortafolio.IService.IHabilidadService;
import com.portafolio.BackendPortafolio.Repository.HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HabilidadService implements IHabilidadService {

    @Autowired
    private HabilidadRepository habilidadRepository;


    @Override
    public Habilidad crearHabilidad(Habilidad habilidad) {
        return habilidadRepository.save(habilidad);
    }

    @Override
    public Habilidad editarHabilidad(Long id, Habilidad habilidad) {
        Habilidad habilidadAEditar = obtenerHabilidad(id);
        habilidadAEditar.setDescripcion(habilidad.getDescripcion());
        habilidadAEditar.setPorcentaje(habilidad.getPorcentaje());
        habilidadAEditar.setUrlImagen(habilidad.getUrlImagen());
        return habilidadRepository.save(habilidadAEditar);
    }

    @Override
    public List<Habilidad> listadoHabilidades() {
        return habilidadRepository.findAll();
    }

    @Override
    public Habilidad obtenerHabilidad(Long id) {
        return habilidadRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No existe la habilidad con id: " + id));
    }

    @Override
    public void eliminarHabilidad(Long id) {
        habilidadRepository.deleteById(id);
    }

    @Override
    public List<Habilidad> listadoHabilidadesPorPersona(Long idPersona) {
        return habilidadRepository.findByPersona_Id(idPersona);
    }
}
