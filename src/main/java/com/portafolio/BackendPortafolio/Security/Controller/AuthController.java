package com.portafolio.BackendPortafolio.Security.Controller;

import com.portafolio.BackendPortafolio.Dto.Message;
import com.portafolio.BackendPortafolio.Exception.InvalidDataException;
import com.portafolio.BackendPortafolio.Exception.UnauthorizedException;
import com.portafolio.BackendPortafolio.Security.Dto.JwtDto;
import com.portafolio.BackendPortafolio.Security.Dto.LoginUsuario;
import com.portafolio.BackendPortafolio.Security.Jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/login")
    @PreAuthorize("permitAll()")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new InvalidDataException(bindingResult);
        }
        try{
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getUsername(), loginUsuario.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateToken(authentication);
            JwtDto jwtDto = new JwtDto(jwt);
            return new ResponseEntity<>(jwtDto, HttpStatus.OK);
        }catch (InternalAuthenticationServiceException e){
            throw new UnauthorizedException("Nombre de usuario incorrecto");
        }catch (BadCredentialsException e){
            throw new UnauthorizedException("Contraseña incorrecta");
        }catch (LockedException e){
            throw new UnauthorizedException("Usuario bloqueado");
        }
    }

}
