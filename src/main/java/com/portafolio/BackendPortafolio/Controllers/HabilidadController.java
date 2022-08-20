package com.portafolio.BackendPortafolio.Controllers;

import com.portafolio.BackendPortafolio.Dto.HabilidadDto;
import com.portafolio.BackendPortafolio.Dto.Message;
import com.portafolio.BackendPortafolio.Entity.Habilidad;
import com.portafolio.BackendPortafolio.Entity.Persona;
import com.portafolio.BackendPortafolio.Exception.InvalidDataException;
import com.portafolio.BackendPortafolio.Service.HabilidadService;
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
@RequestMapping("/habilidades")
@CrossOrigin("*")
public class HabilidadController {

    @Autowired
    private HabilidadService habilidadService;

    @Autowired
    private PersonaService personaService;

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> crearHabilidad(@Valid @RequestBody HabilidadDto habilidadDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidDataException(bindingResult);
        }
        Persona persona = personaService.obtenerPersona(habilidadDto.getIdPersona());
        Habilidad nuevaHabilidad = new Habilidad(
                habilidadDto.getDescripcion(),
                habilidadDto.getUrlImagen(),
                habilidadDto.getPorcentaje(),
                persona
        );
        habilidadService.crearHabilidad(nuevaHabilidad);
        return new ResponseEntity<>(new Message("Habilidad guardada correctamente"), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> editarHabilidad(@PathVariable Long id, @Valid @RequestBody HabilidadDto habilidadDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidDataException(bindingResult);
        }
        Habilidad habilidad = habilidadService.obtenerHabilidad(id);
        Habilidad habilidadEditar = new Habilidad(
                habilidadDto.getDescripcion(),
                habilidadDto.getUrlImagen(),
                habilidadDto.getPorcentaje(),
                habilidad.getPersona()
        );
        habilidadService.editarHabilidad(habilidad.getId(), habilidadEditar);
        return new ResponseEntity<>(new Message("Habilidad guardada correctamente"),HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Habilidad>> listadoHabilidades(){
        List<Habilidad> habilidades = habilidadService.listadoHabilidades();
        return new ResponseEntity<>(habilidades,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Habilidad> detalleHabilidad(@PathVariable Long id){
        Habilidad habilidad = habilidadService.obtenerHabilidad(id);
        return new ResponseEntity<>(habilidad,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarHabilidad(@PathVariable Long id){
        Habilidad habilidad = habilidadService.obtenerHabilidad(id);
        habilidadService.eliminarHabilidad(habilidad.getId());
        return new ResponseEntity<>(new Message("Habilidad eliminada correctamente"),HttpStatus.OK);
    }
}
