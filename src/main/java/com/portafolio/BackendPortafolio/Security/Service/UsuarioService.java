package com.portafolio.BackendPortafolio.Security.Service;

import com.portafolio.BackendPortafolio.Exception.BadRequestException;
import com.portafolio.BackendPortafolio.Exception.ResourceNotFoundException;
import com.portafolio.BackendPortafolio.Security.Entity.Usuario;
import com.portafolio.BackendPortafolio.Security.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario guardarUsuario(Usuario usuario){
        if(usuarioRepository.existsByUserName(usuario.getUserName())){
            throw new BadRequestException("Ya existe un usuario con el username: " + usuario.getUserName());
        }
        if(usuarioRepository.existsByEmail(usuario.getEmail())){
            throw new BadRequestException("Ya existe un usuario con el email: " + usuario.getEmail());
        }
        return usuarioRepository.save(usuario);

    }

    public Usuario obtenerUsuario(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe un usuario con el ID: " + id));
    }

    public Usuario obtenerUsuarioPorUserNameOEmail(String userNameOrEmail){
        return usuarioRepository.findByEmailOrUserName(userNameOrEmail, userNameOrEmail)
                .orElseThrow(()-> new ResourceNotFoundException("No existe el usuario con username o email: " + userNameOrEmail));
    }

    public Usuario editarUsuario(Long id, Usuario usuarioEditado){
        Usuario usuario = obtenerUsuario(id);
        if(!usuario.getUserName().equals(usuarioEditado.getUserName()) && usuarioRepository.existsByUserName(usuarioEditado.getUserName())){
            throw new BadRequestException("Ya existe un usuario con el username: " + usuario.getUserName());
        }
        if(!usuario.getEmail().equals(usuarioEditado.getEmail()) && usuarioRepository.existsByEmail(usuarioEditado.getEmail())){
            throw new BadRequestException("Ya existe un usuario con el email: " + usuario.getEmail());
        }
        usuario.setUserName(usuarioEditado.getUserName());
        usuario.setEmail(usuarioEditado.getUserName());
        usuario.setRol(usuarioEditado.getRol());

        return usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Long id){
        Usuario usuario = obtenerUsuario(id);
        usuarioRepository.deleteById(id);
    }
}
