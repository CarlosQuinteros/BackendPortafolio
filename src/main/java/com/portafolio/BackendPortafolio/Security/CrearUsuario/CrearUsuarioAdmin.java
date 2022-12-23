package com.portafolio.BackendPortafolio.Security.CrearUsuario;

import com.portafolio.BackendPortafolio.Security.Entity.Usuario;
import com.portafolio.BackendPortafolio.Security.Enum.Rol;
import com.portafolio.BackendPortafolio.Security.Repository.UsuarioRepository;
import com.portafolio.BackendPortafolio.Security.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CrearUsuarioAdmin implements CommandLineRunner {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {


        Usuario usuarioAdmin = usuarioService.obtenerUsuarioPorUserNameOEmail("carloscq");
        System.out.println(usuarioAdmin.getUserName() + ": " + usuarioAdmin.getEmail());
        usuarioAdmin.setPassword(passwordEncoder.encode("CFMcarloscq17*"));
        usuarioRepository.save(usuarioAdmin);


        /*Usuario usuarioAdmin = new Usuario("carloscq","carlos.dante.quinteros@gmail.com",passwordEncoder.encode("carloscq17*"), Rol.ROLE_ADMIN);
        usuarioService.guardarUsuario(usuarioAdmin);*/

    }
}
