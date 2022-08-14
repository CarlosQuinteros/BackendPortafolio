package com.portafolio.BackendPortafolio.IService;

import com.portafolio.BackendPortafolio.Entity.Educacion;
import com.portafolio.BackendPortafolio.Entity.Persona;

import java.util.List;

public interface IPersonaService {
    public List<Persona> listadoPersonas();
    public Persona crearPersona(Persona persona);
    public Persona editarPersona(Long idPersonaEditar, Persona persona);
    public void eliminarPersona(Long id);
    public Persona obtenerPersona(Long id);
    public Persona obtenerPersonaPorDni(String dni);
}
