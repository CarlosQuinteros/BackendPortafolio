package com.portafolio.BackendPortafolio.Service;

import com.portafolio.BackendPortafolio.Entity.Educacion;
import com.portafolio.BackendPortafolio.Exception.ResourceNotFoundException;
import com.portafolio.BackendPortafolio.IService.IEducacionService;
import com.portafolio.BackendPortafolio.Repository.EducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EducacionService implements IEducacionService {

    @Autowired
    private EducacionRepository educacionRepository;

    @Override
    public List<Educacion> listadoEducaciones() {
        return educacionRepository.findAll();
    }

    @Override
    public Educacion crearEducacion(Educacion educacion) {
        return educacionRepository.save(educacion);
    }

    @Override
    public Educacion editarEducacion(Long id, Educacion educacion) {
        Educacion educacionAEditar = obtenerEducacion(id);
        educacionAEditar.setInstitucion(educacion.getInstitucion());
        educacionAEditar.setFechaDesde(educacion.getFechaDesde());
        educacionAEditar.setFechaHasta(educacion.getFechaHasta());
        educacionAEditar.setTitulo(educacion.getTitulo());
        educacionAEditar.setUrlImagen(educacion.getUrlImagen());
        return educacionRepository.save(educacionAEditar);
    }

    @Override
    public void eliminarEducacion(Long id) {
        educacionRepository.deleteById(id);
    }

    @Override
    public Educacion obtenerEducacion(Long id) {
        return educacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe la educacion con Id: " + id));
    }

    @Override
    public List<Educacion> listadoEducacionesPorPersona(Long idPersona) {
        return educacionRepository.findByPersona_Id(idPersona);
    }
}
