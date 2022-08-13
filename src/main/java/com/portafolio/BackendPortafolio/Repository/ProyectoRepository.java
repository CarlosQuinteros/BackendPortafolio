package com.portafolio.BackendPortafolio.Repository;

import com.portafolio.BackendPortafolio.Entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    List<Proyecto> findByPersona_Id(Long id);
}
