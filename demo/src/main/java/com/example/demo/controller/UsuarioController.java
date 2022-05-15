package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    //Get de todos los usuarios
    @GetMapping("/user")
    public ResponseEntity<Iterable<Usuario>> retrieveUsers(@RequestParam(required=false) String estado) {
        
        Iterable<Usuario> response = usuarioService.getUsuarios();
        return ResponseEntity.ok().body(response);
    }

    //Get de solamente el usuario con ese id
    @GetMapping("/user/{correo}")
    private Usuario getUser(@PathVariable("correo") String correo) {
        
        //Long idLong = Long.parseLong(id); 
        return usuarioService.getUserByMail(correo);
    }

    //Meter un usuario
    @PostMapping("/user")
    public ResponseEntity<Usuario> createUserById(
        @RequestBody Usuario user){
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        Usuario newUser = usuarioService.createUser(user);
        return ResponseEntity.ok().body(newUser);
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> deleteUser(@PathVariable String id) {
        Long idLong = Long.parseLong(id); 
        userRepository.deleteById(idLong);
        return ResponseEntity.noContent().build();
    }
   
    //Actualizar todos los parámetros de un usuario
    @PutMapping("/usuarios/{id}")
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