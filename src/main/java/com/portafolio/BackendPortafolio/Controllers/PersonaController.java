package com.portafolio.BackendPortafolio.Controllers;

import com.portafolio.BackendPortafolio.Dto.Message;
import com.portafolio.BackendPortafolio.Dto.PersonaDto;
import com.portafolio.BackendPortafolio.Entity.Domicilio;
import com.portafolio.BackendPortafolio.Entity.Persona;
import com.portafolio.BackendPortafolio.Exception.InvalidDataException;
import com.portafolio.BackendPortafolio.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    @GetMapping("")
    public ResponseEntity<List<Persona>> listadoDePersonas(){
        List<Persona> personas = personaService.listadoPersonas();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @PostMapping("")
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
    public ResponseEntity<Persona> detallePersona(@PathVariable Long id){
        Persona persona = personaService.obtenerPersona(id);
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }


}
