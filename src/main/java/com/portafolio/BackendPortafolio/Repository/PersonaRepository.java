package com.portafolio.BackendPortafolio.Repository;

import com.portafolio.BackendPortafolio.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    boolean existsByDocumento(String documento);
    boolean existsByCorreo(String correo);
}
