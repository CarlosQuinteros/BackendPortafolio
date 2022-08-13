package com.portafolio.BackendPortafolio.Controllers;

import com.portafolio.BackendPortafolio.Dto.EducacionDto;
import com.portafolio.BackendPortafolio.Dto.Message;
import com.portafolio.BackendPortafolio.Entity.Educacion;
import com.portafolio.BackendPortafolio.Entity.Persona;
import com.portafolio.BackendPortafolio.Exception.InvalidDataException;
import com.portafolio.BackendPortafolio.Service.EducacionService;
import com.portafolio.BackendPortafolio.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/educaciones")
@CrossOrigin("*")
public class EducacionController {

    @Autowired
    private EducacionService educacionService;

    @Autowired
    private PersonaService personaService;

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> crearEducacion(@Valid @RequestBody EducacionDto educacionDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidDataException(bindingResult);
        }
        Persona persona = personaService.obtenerPersona(educacionDto.getIdPersona());
        Educacion nuevaEducacion = new Educacion(
                educacionDto.getInstitucion(),
                educacionDto.getUrlImagen(),
                educacionDto.getTitulo(),
                educacionDto.getFechaDesde(),
                educacionDto.getFechaHasta(),
                persona
        );
        educacionService.crearEducacion(nuevaEducacion);
        return new ResponseEntity<>(new Message("Educacion guardada correctamente"), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> editarEducacion(@PathVariable Long id,@Valid @RequestBody EducacionDto educacionDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidDataException(bindingResult);
        }
        Educacion educacion = educacionService.obtenerEducacion(id);
        Educacion educacionEditar = new Educacion(
                educacionDto.getInstitucion(),
                educacionDto.getUrlImagen(),
                educacionDto.getTitulo(),
                educacionDto.getFechaDesde(),
                educacionDto.getFechaHasta(),
                educacion.getPersona()
        );
        educacionService.editarEducacion(educacion.getId(), educacionEditar);
        return new ResponseEntity<>(new Message("Educacion guardada correctamente"),HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Educacion>> listadoEducaciones(){
        List<Educacion> educaciones = educacionService.listadoEducaciones();
        return new ResponseEntity<>(educaciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Educacion> detalleEducacion(@PathVariable Long id){
        Educacion educacion = educacionService.obtenerEducacion(id);
        return new ResponseEntity<>(educacion, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> eliminarEducacion(@PathVariable Long id){
        Educacion educacion = educacionService.obtenerEducacion(id);
        educacionService.eliminarEducacion(educacion.getId());
        return new ResponseEntity<>(new Message("Educacion eliminada correctamente"),HttpStatus.OK);
    }
}
