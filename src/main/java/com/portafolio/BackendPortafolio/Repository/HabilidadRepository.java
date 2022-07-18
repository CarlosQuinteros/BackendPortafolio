package com.portafolio.BackendPortafolio.Repository;

import com.portafolio.BackendPortafolio.Entity.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, Long> {
}
