package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    // @Autowired
    // private PasswordEncoder passwordEncoder;

    @GetMapping("/usario")
    public ResponseEntity<Iterable<Usuario>> retrieveUsers() {
        Iterable<Usuario> response = usuarioService.getUsuarios();
        return ResponseEntity.ok().body(response);
    }


    @PostMapping("/usuario")
    public ResponseEntity<Usuario> createUserById(
        @RequestBody Usuario user){
        // String hashedPassword = passwordEncoder.encode(user.getPassword());
        // user.setPassword(hashedPassword);

        Usuario newUser = usuarioService.createUser(user);
        return ResponseEntity.ok().body(newUser);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Usuario> deleteUser(@PathVariable String id) {
        Long idLong = Long.parseLong(id); 
        usuarioService.deleteByID(idLong);
        return ResponseEntity.noContent().build();
    }
   
    //Actualizar todos los parámetros de un usuario
    @PutMapping("/usuario/{id}")
    public ResponseEntity<Usuario> updateUser( @PathVariable String id) {
        Long idlong = Long.parseLong(id);
        Usuario usuario = usuarioService.getUserById(idlong);
        usuarioService.updateUser(usuario);
        if(usuario == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(usuario);
    }
}