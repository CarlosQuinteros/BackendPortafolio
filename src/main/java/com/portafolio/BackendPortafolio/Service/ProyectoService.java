package com.portafolio.BackendPortafolio.Service;

import com.portafolio.BackendPortafolio.Entity.Proyecto;
import com.portafolio.BackendPortafolio.Exception.ResourceNotFoundException;
import com.portafolio.BackendPortafolio.IService.IProyectoService;
import com.portafolio.BackendPortafolio.Repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProyectoService implements IProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    public Proyecto crearProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    @Override
    public Proyecto editarProyecto(Long id, Proyecto proyecto) {
        Proyecto proyectoAEditar = obtenerProyecto(id);
        proyectoAEditar.setDescripcion(proyecto.getDescripcion());
        proyectoAEditar.setNombre(proyecto.getNombre());
        proyectoAEditar.setUrlRepositorio(proyecto.getUrlRepositorio());
        return proyectoRepository.save(proyectoAEditar);
    }

    @Override
    public Proyecto obtenerProyecto(Long id) {
        return proyectoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el proyecto con id: " + id));
    }

    @Override
    public List<Proyecto> listadoProyectos() {
        return proyectoRepository.findAll();
    }

    @Override
    public List<Proyecto> listadoProyectosPorPersona(Long idPersona) {
        return proyectoRepository.findByPersona_Id(idPersona);
    }

    @Override
    public void eliminarProyecto(Long id) {
        Proyecto proyecto = obtenerProyecto(id);
        proyectoRepository.deleteById(proyecto.getId());
    }
}
