package com.example.demo.service;

import com.example.demo.model.Usuario;

public interface UsuarioService {
    Iterable<Usuario> getUsuarios();

    void deleteUsuario(Long id);

    Usuario getUserById(Long id);

    void createUser(Usuario usuario);
}
