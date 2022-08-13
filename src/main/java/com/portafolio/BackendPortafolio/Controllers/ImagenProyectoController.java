package com.portafolio.BackendPortafolio.Controllers;

import com.portafolio.BackendPortafolio.Dto.ImagenProyectoDto;
import com.portafolio.BackendPortafolio.Dto.Message;
import com.portafolio.BackendPortafolio.Entity.ImagenProyecto;
import com.portafolio.BackendPortafolio.Entity.Proyecto;
import com.portafolio.BackendPortafolio.Exception.InvalidDataException;
import com.portafolio.BackendPortafolio.Service.ImagenProyectoService;
import com.portafolio.BackendPortafolio.Service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/imagen-proyectos")
public class ImagenProyectoController {

    @Autowired
    private ImagenProyectoService imagenProyectoService;

    @Autowired
    private ProyectoService proyectoService;


    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> crearImagenProyecto(@Valid @RequestBody ImagenProyectoDto imagenProyectoDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidDataException(bindingResult);
        }
        Proyecto proyecto = proyectoService.obtenerProyecto(imagenProyectoDto.getIdProyecto());
        ImagenProyecto imagenProyecto = new ImagenProyecto(imagenProyectoDto.getUrl(), imagenProyectoDto.getDescripcion(), proyecto);
        imagenProyectoService.crearImagenProyecto(imagenProyecto);
        return new ResponseEntity<>(new Message("Imagen guardada correctamente"), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> editarImagenProyecto(@PathVariable Long id, @Valid @RequestBody ImagenProyectoDto imagenProyectoDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidDataException(bindingResult);
        }
        ImagenProyecto imagenProyectoAEditar = imagenProyectoService.obtenerImagenProyecto(id);
        ImagenProyecto imagenProyecto = new ImagenProyecto(
                imagenProyectoDto.getUrl(),
                imagenProyectoDto.getDescripcion(),
                imagenProyectoAEditar.getProyecto());
        imagenProyectoService.editarImagenProyecto(imagenProyectoAEditar.getId(), imagenProyecto);
        return new ResponseEntity<>(new Message("Imagen guardada correctamente"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> eliminarImagenProyecto(@PathVariable Long id){
        ImagenProyecto imagenProyecto = imagenProyectoService.obtenerImagenProyecto(id);
        imagenProyectoService.eliminarImagenProyecto(imagenProyecto.getId());
        return new ResponseEntity<>(new Message("Imagen eliminada correctamente"),HttpStatus.OK);
    }




}
