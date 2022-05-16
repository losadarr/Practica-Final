package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public Iterable<Usuario> getUsuarios() {
        return userRepository.findAll();
    }

    @Override
    public void deleteByID(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Usuario getUserById(Long id) {
        Optional<Usuario> usuario = userRepository.findById(id);
        if(usuario.isEmpty()){
            return null;
        }
        return usuario.get();
    }

    @Override
    public Usuario createUser(Usuario usuario){
        usuario.setId(null);
        return userRepository.save(usuario);
    }


    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException{
        Usuario user = userRepository.findByCorreo(correo);
        List<GrantedAuthority> roles = new ArrayList<>();
        UserDetails usuario = new User(user.getCorreo(), user.getPassword(), roles);
        return usuario;
    }

    @Override
    public Usuario updateUser(Usuario usuario) {
        Usuario usuario_cambiar = userRepository.findById(usuario.getId()).get();
        if(usuario_cambiar == null){
            return null;
        }
        usuario_cambiar.setCorreo(usuario.getCorreo());
        usuario_cambiar.setPassword(usuario.getPassword());
        userRepository.save(usuario_cambiar);
        return usuario_cambiar;
    }

}
