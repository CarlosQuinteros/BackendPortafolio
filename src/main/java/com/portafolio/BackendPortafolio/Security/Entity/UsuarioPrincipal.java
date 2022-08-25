package com.portafolio.BackendPortafolio.Security.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UsuarioPrincipal implements UserDetails {

    private String userName;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;


    public UsuarioPrincipal(String userName, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UsuarioPrincipal build(Usuario usuario){
        GrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRol().name());
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(authority);
        return new UsuarioPrincipal(usuario.getUserName(), usuario.getEmail(), usuario.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
