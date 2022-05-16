package com.example.demo.service;

import com.example.demo.model.Usuario;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioService extends UserDetailsService {
    Iterable<Usuario> getUsuarios();
    void deleteByID(Long id);
    Usuario getUserById(Long id);
    Usuario createUser(Usuario usuario);
    Usuario updateUser(Usuario usuario);
}
