package com.portafolio.BackendPortafolio.Controllers;

import com.portafolio.BackendPortafolio.Dto.ExperienciaDto;
import com.portafolio.BackendPortafolio.Dto.Message;
import com.portafolio.BackendPortafolio.Entity.ExperienciaLaboral;
import com.portafolio.BackendPortafolio.Entity.Persona;
import com.portafolio.BackendPortafolio.Enum.TipoJornada;
import com.portafolio.BackendPortafolio.Exception.InvalidDataException;
import com.portafolio.BackendPortafolio.Service.ExperienciaLaboralService;
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
@RequestMapping("/experiencias-laborales")
@CrossOrigin("*")
public class ExperienciaLaboralController {

    @Autowired
    private ExperienciaLaboralService experienciaLaboralService;

    @Autowired
    private PersonaService personaService;

    @PostMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> crearExperienciaLaboral(@Valid @RequestBody ExperienciaDto experienciaDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidDataException(bindingResult);
        }
        TipoJornada tipoJornada = experienciaLaboralService.obtenerTipoJornadaPorNombre(experienciaDto.getTipoJornada());
        Persona persona = personaService.obtenerPersona(experienciaDto.getIdPersona());
        ExperienciaLaboral nuevaExperienciaLaboral = new ExperienciaLaboral(
                experienciaDto.getOrganizacion(),
                experienciaDto.getUrlImagen(),
                experienciaDto.getPuesto(),
                experienciaDto.getTareas(),
                tipoJornada,
                experienciaDto.getFechaDesde(),
                experienciaDto.getFechaHasta(),
                persona
        );
        experienciaLaboralService.crearExperiencia(nuevaExperienciaLaboral);
        return new ResponseEntity<>(new Message("Experiencia laboral guardada correctamente"), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> crearExperienciaLaboral(@PathVariable Long id, @Valid @RequestBody ExperienciaDto experienciaDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidDataException(bindingResult);
        }
        ExperienciaLaboral experienciaLaboral = experienciaLaboralService.obtenerExperiencia(id);
        TipoJornada tipoJornada = experienciaLaboralService.obtenerTipoJornadaPorNombre(experienciaDto.getTipoJornada());
        ExperienciaLaboral experienciaLaboralEditar = new ExperienciaLaboral(
                experienciaDto.getOrganizacion(),
                experienciaDto.getUrlImagen(),
                experienciaDto.getPuesto(),
                experienciaDto.getTareas(),
                tipoJornada,
                experienciaDto.getFechaDesde(),
                experienciaDto.getFechaHasta(),
                experienciaLaboral.getPersona()
        );
        experienciaLaboralService.editarExperiencia(experienciaLaboral.getId(), experienciaLaboralEditar);
        return new ResponseEntity<>(new Message("Experiencia laboral guardada correctamente"), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<ExperienciaLaboral>> listadoExperienciasLaborales(){
        List<ExperienciaLaboral> experienciasLaborales = experienciaLaboralService.listadoExperiencias();
        return new ResponseEntity<>(experienciasLaborales, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ExperienciaLaboral> detalleExperienciaLaboral(@PathVariable Long id){
        ExperienciaLaboral experienciaLaboral = experienciaLaboralService.obtenerExperiencia(id);
        return new ResponseEntity<>(experienciaLaboral,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> eliminarExperienciaLaboral(@PathVariable Long id){
        ExperienciaLaboral experienciaLaboral = experienciaLaboralService.obtenerExperiencia(id);
        experienciaLaboralService.eliminarExperiencia(experienciaLaboral.getId());
        return new ResponseEntity<>(new Message("Experiencia laboral eliminada correctamente"),HttpStatus.OK);
    }



}
