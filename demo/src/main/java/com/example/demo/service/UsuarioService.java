package com.example.demo.service;

import com.example.demo.model.Usuario;

import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioService {
    Iterable<Usuario> getUsuarios();
    void deleteByID(Long id);
    Usuario getUserById(Long id);
    Usuario getUserByMail(String correo);
    Usuario createUser(Usuario usuario);
    Usuario updateUser(Usuario usuario);
    UserDetails loadUserByEmail(String correo);
}
