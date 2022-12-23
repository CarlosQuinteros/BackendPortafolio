package com.portafolio.BackendPortafolio.Service;

import com.portafolio.BackendPortafolio.Entity.Persona;
import com.portafolio.BackendPortafolio.Exception.BadRequestException;
import com.portafolio.BackendPortafolio.Exception.ResourceNotFoundException;
import com.portafolio.BackendPortafolio.IService.IPersonaService;
import com.portafolio.BackendPortafolio.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> listadoPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public Persona crearPersona(Persona persona) {
        if(personaRepository.existsByDocumento(persona.getDocumento())){
            throw new BadRequestException("Ya existe una persona con el documetno: " + persona.getDocumento());
        }
        if(personaRepository.existsByCorreo(persona.getCorreo())){
            throw new BadRequestException("Ya existe una persona con el correo: " + persona.getCorreo());
        }
        return personaRepository.save(persona);
    }

    @Override
    public Persona editarPersona(Long idPersonaEditar, Persona persona) {
        Persona personaEditar = obtenerPersona(idPersonaEditar);
        if(!personaEditar.getDocumento().equals(persona.getDocumento()) && personaRepository.existsByDocumento(persona.getDocumento())){
            throw new BadRequestException("Ya existe una persona con el documento: " + persona.getDocumento());
        }
        if(!personaEditar.getCorreo().equals(persona.getCorreo()) && personaRepository.existsByCorreo(persona.getCorreo())){
            throw new BadRequestException("Ya existe una persona con el correo: " + persona.getCorreo());
        }
        personaEditar.setNombres(persona.getNombres());
        personaEditar.setApellido(persona.getApellido());
        personaEditar.setDocumento(persona.getDocumento());
        personaEditar.setCorreo(persona.getCorreo());
        personaEditar.setAcercaDe(persona.getAcercaDe());
        personaEditar.setFechaNacimiento(persona.getFechaNacimiento());
        personaEditar.setTelefono(persona.getTelefono());
        personaEditar.setUrlCurriculum(persona.getUrlCurriculum());
        personaEditar.setUrlImagen(persona.getUrlImagen());
        personaEditar.getDomicilio().setCalle(persona.getDomicilio().getCalle());
        personaEditar.getDomicilio().setNumero(persona.getDomicilio().getNumero());
        personaEditar.getDomicilio().setLocalidad(persona.getDomicilio().getLocalidad());

        return personaRepository.save(personaEditar);
    }

    @Override
    public void eliminarPersona(Long id) {
        Persona persona = obtenerPersona(id);
        personaRepository.deleteById(persona.getId());
    }

    @Override
    public Persona obtenerPersona(Long id) {
        return personaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No existe la persona con id: " + id));
    }

    @Override
    public Persona obtenerPersonaPorDni(String dni) {
        return personaRepository.findByDocumento(dni)
                .orElseThrow(() -> new ResourceNotFoundException("No existe la persona con dni: " + dni));
    }
}
