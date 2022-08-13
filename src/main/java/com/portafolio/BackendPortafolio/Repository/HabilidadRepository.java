package com.portafolio.BackendPortafolio.Repository;

import com.portafolio.BackendPortafolio.Entity.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, Long> {
    List<Habilidad> findByPersona_Id(Long idPersona);
}
