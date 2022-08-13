package com.portafolio.BackendPortafolio.Controllers;

import com.portafolio.BackendPortafolio.Dto.ImagenProyectoDto;
import com.portafolio.BackendPortafolio.Dto.Message;
import com.portafolio.BackendPortafolio.Dto.ProyectoDto;
import com.portafolio.BackendPortafolio.Entity.ImagenProyecto;
import com.portafolio.BackendPortafolio.Entity.Persona;
import com.portafolio.BackendPortafolio.Entity.Proyecto;
import com.portafolio.BackendPortafolio.Exception.InvalidDataException;
import com.portafolio.BackendPortafolio.Service.ImagenProyectoService;
import com.portafolio.BackendPortafolio.Service.PersonaService;
import com.portafolio.BackendPortafolio.Service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/proyectos")
@CrossOrigin("*")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @Autowired
    private PersonaService personaService;

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> crearProyecto(@Valid @RequestBody ProyectoDto proyectoDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidDataException(bindingResult);
        }
        Persona persona = personaService.obtenerPersona(proyectoDto.getIdPersona());
        Proyecto nuevoProyecto = new Proyecto(
                proyectoDto.getNombre(),
                proyectoDto.getDescripcion(),
                proyectoDto.getUrlRepositorio(),
                persona
        );
        proyectoService.crearProyecto(nuevoProyecto);
        return new ResponseEntity<>(new Message("Proyecto guardado correctamente"), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> editarProyecto(@PathVariable Long id, @Valid @RequestBody ProyectoDto proyectoDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidDataException(bindingResult);
        }
        Proyecto proyecto = proyectoService.obtenerProyecto(id);
        Proyecto proyectoEditar = new Proyecto(
                proyectoDto.getNombre(),
                proyectoDto.getDescripcion(),
                proyectoDto.getUrlRepositorio(),
                proyecto.getPersona()
        );
        proyectoService.editarProyecto(proyecto.getId(), proyectoEditar);
        return new ResponseEntity<>(new Message("Proyecto guardado correctamente"), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> detalleProyecto(@PathVariable Long id){
        Proyecto proyecto = proyectoService.obtenerProyecto(id);
        return new ResponseEntity<>(proyecto,HttpStatus.OK);
    }

    @GetMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Proyecto>> listadoProyectos(){
        List<Proyecto> proyectos = proyectoService.listadoProyectos();
        return new ResponseEntity<>(proyectos,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> eliminarProyecto(@PathVariable Long id){
        Proyecto proyecto = proyectoService.obtenerProyecto(id);
        proyectoService.eliminarProyecto(proyecto.getId());
        return new ResponseEntity<>(new Message("Proyecto eliminado correctamente"),HttpStatus.OK);
    }
}
