package com.example.demo.service.impl;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public Iterable<Usuario> getUsuarios() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUsuario(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Usuario getUserById(Long id) {
        return  userRepository.findById(id).get();
    }

    @Override
    public void createUser(Usuario usuario){
        Long id=usuario.getId();
        String correo=usuario.getCorreo();
        String password=usuario.getPassword();
        userRepository.newUser(id,correo,password);
    }

    @Override
    public Usuario getUserByMail(String correo) {
        return userRepository.getUserByMail(correo);
    }
}
