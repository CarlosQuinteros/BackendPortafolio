package com.portafolio.BackendPortafolio.Repository;

import com.portafolio.BackendPortafolio.Entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Long> {
    List<Educacion> findByPersona_Id(Long idPersona);
}
