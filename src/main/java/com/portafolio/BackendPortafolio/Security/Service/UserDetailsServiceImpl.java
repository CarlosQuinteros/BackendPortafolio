package com.portafolio.BackendPortafolio.Security.Service;

import com.portafolio.BackendPortafolio.Security.Entity.Usuario;
import com.portafolio.BackendPortafolio.Security.Entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.obtenerUsuarioPorUserNameOEmail(usernameOrEmail);
        return UsuarioPrincipal.build(usuario);
    }
}
