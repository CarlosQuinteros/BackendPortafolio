package com.portafolio.BackendPortafolio.Service;

import com.portafolio.BackendPortafolio.Entity.ImagenProyecto;
import com.portafolio.BackendPortafolio.Exception.ResourceNotFoundException;
import com.portafolio.BackendPortafolio.IService.IImagenProyectoService;
import com.portafolio.BackendPortafolio.Repository.ImagenProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ImagenProyectoService  implements IImagenProyectoService {

    @Autowired
    private ImagenProyectoRepository imagenProyectoRepository;

    @Override
    public ImagenProyecto crearImagenProyecto(ImagenProyecto imagenProyecto) {
        return imagenProyectoRepository.save(imagenProyecto);
    }

    @Override
    public ImagenProyecto editarImagenProyecto(Long id, ImagenProyecto imagenProyecto) {
        ImagenProyecto imagenProyectoObtenido = obtenerImagenProyecto(id);
        imagenProyectoObtenido.setDescripcion(imagenProyecto.getDescripcion());
        imagenProyectoObtenido.setUrl(imagenProyecto.getUrl());
        return imagenProyectoRepository.save(imagenProyectoObtenido);
    }

    @Override
    public void eliminarImagenProyecto(Long id) {
        ImagenProyecto imagenProyecto = obtenerImagenProyecto(id);
        imagenProyectoRepository.deleteById(imagenProyecto.getId());
    }

    @Override
    public List<ImagenProyecto> listadoImagenProyecto() {
        return imagenProyectoRepository.findAll();
    }

    @Override
    public ImagenProyecto obtenerImagenProyecto(Long id) {
        return imagenProyectoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe la imagen de proyecto con id: " + id));
    }
}
