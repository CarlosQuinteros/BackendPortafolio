package com.portafolio.BackendPortafolio.Repository;

import com.portafolio.BackendPortafolio.Entity.ExperienciaLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienciaLaboralRepository extends JpaRepository<ExperienciaLaboral, Long> {
    List<ExperienciaLaboral> findByPersona_Id(Long idPersona);
}
