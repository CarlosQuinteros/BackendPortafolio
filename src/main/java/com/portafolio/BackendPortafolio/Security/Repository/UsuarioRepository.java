package com.portafolio.BackendPortafolio.Security.Repository;

import com.portafolio.BackendPortafolio.Security.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmail(String email);

    boolean existsByUserName(String userName);

    Optional<Usuario> findByEmailOrUserName(String email, String userName);
}
