package com.portafolio.BackendPortafolio.IService;

import com.portafolio.BackendPortafolio.Entity.ImagenProyecto;

import java.util.List;

public interface IImagenProyectoService {
    public ImagenProyecto crearImagenProyecto(ImagenProyecto imagenProyecto);
    public ImagenProyecto editarImagenProyecto(Long id, ImagenProyecto imagenProyecto);
    public void eliminarImagenProyecto(Long id);
    public List<ImagenProyecto> listadoImagenProyecto();
    public ImagenProyecto obtenerImagenProyecto(Long id);

}
