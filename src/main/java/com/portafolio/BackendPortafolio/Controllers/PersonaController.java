package com.portafolio.BackendPortafolio.Controllers;

import com.portafolio.BackendPortafolio.Dto.Message;
import com.portafolio.BackendPortafolio.Dto.PersonaDto;
import com.portafolio.BackendPortafolio.Entity.*;
import com.portafolio.BackendPortafolio.Exception.InvalidDataException;
import com.portafolio.BackendPortafolio.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/personas")
@CrossOrigin("*")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private EducacionService educacionService;

    @Autowired
    private ExperienciaLaboralService experienciaLaboralService;

    @Autowired
    private HabilidadService habilidadService;

    @Autowired
    private ProyectoService proyectoService;

    @GetMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Persona>> listadoDePersonas(){
        List<Persona> personas = personaService.listadoPersonas();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> crearPersona(@Valid @RequestBody PersonaDto personaDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidDataException(bindingResult);
        }
        Domicilio domicilio = new Domicilio(personaDto.getCalle(), personaDto.getNumero(), personaDto.getLocalidad());
        Persona nuevaPersona = new Persona(
                personaDto.getNombre(),
                personaDto.getApellido(),
                personaDto.getDocumento(),
                personaDto.getFechaNacimiento(),
                personaDto.getAcercaDe(),
                personaDto.getUrlImagen(),
                personaDto.getCorreo(),
                personaDto.getUrlCurriculum(),
                personaDto.getTelefono(),
                domicilio
        );
        personaService.crearPersona(nuevaPersona);
        return new ResponseEntity<>(new Message("Persona guardada correctamente"),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> editarPersona(@PathVariable Long id, @Valid @RequestBody PersonaDto personaDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidDataException(bindingResult);
        }
        Domicilio domicilio = new Domicilio(personaDto.getCalle(), personaDto.getNumero(), personaDto.getLocalidad());
        Persona personaEditar = new Persona(
                personaDto.getNombre(),
                personaDto.getApellido(),
                personaDto.getDocumento(),
                personaDto.getFechaNacimiento(),
                personaDto.getAcercaDe(),
                personaDto.getUrlImagen(),
                personaDto.getCorreo(),
                personaDto.getUrlCurriculum(),
                personaDto.getTelefono(),
                domicilio
        );
        personaService.editarPersona(id, personaEditar);
        return new ResponseEntity<>(new Message("Persona guardada correctamente"),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Persona> detallePersona(@PathVariable Long id){
        Persona persona = personaService.obtenerPersona(id);
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

    @GetMapping("/{id}/educaciones")
    public ResponseEntity<List<Educacion>> educacionesDePersona(@PathVariable Long id){
        Persona persona = personaService.obtenerPersona(id);
        List<Educacion> educaciones = educacionService.listadoEducacionesPorPersona(persona.getId());
        return new ResponseEntity<>(educaciones, HttpStatus.OK);
    }

    @GetMapping("/{id}/experiencias-laborales")
    public ResponseEntity<List<ExperienciaLaboral>> experienciasLaboralesDePersona(@PathVariable Long id){
        Persona persona = personaService.obtenerPersona(id);
        List<ExperienciaLaboral> experiencias = experienciaLaboralService.listadoExperienciasPorPersona(persona.getId());
        return new ResponseEntity<>(experiencias,HttpStatus.OK);
    }

    @GetMapping("/{id}/habilidades")
    public ResponseEntity<List<Habilidad>> habilidadesDePersona(@PathVariable Long id){
        Persona persona = personaService.obtenerPersona(id);
        List<Habilidad> habilidades = habilidadService.listadoHabilidadesPorPersona(persona.getId());
        return new ResponseEntity<>(habilidades,HttpStatus.OK);
    }

    @GetMapping("/{id}/proyectos")
    public ResponseEntity<List<Proyecto>> proyectosDePersona(@PathVariable Long id){
        Persona persona = personaService.obtenerPersona(id);
        List<Proyecto> proyectos = proyectoService.listadoProyectosPorPersona(persona.getId());
        return new ResponseEntity<>(proyectos,HttpStatus.OK);
    }


}
