package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    
    //Get de todos los usuarios
    @GetMapping("/user")
    public ResponseEntity<Iterable<Usuario>> retrieveUsers(@RequestParam(required=false) String estado) {
        
        Iterable<Usuario> response = usuarioService.getUsuarios();
        return ResponseEntity.ok().body(response);
    }

    //Get de solamente el usuario con ese id
    @GetMapping("/user/{id}")
    private Usuario getUser(@PathVariable("id") String id) {
        Long idLong = Long.parseLong(id); 
        return usuarioService.getUserById(idLong);
    }

    //Meter un usuario
    @PostMapping("/user")
    public ResponseEntity<String> createUserById(
        @RequestBody Usuario usuario,
        BindingResult bindingResult){

        if(bindingResult.hasErrors()){
        return new ResponseEntity<String>("{\"result\" : \"KO\"}", HttpStatus.BAD_REQUEST);
        }else{
            usuarioService.createUser(usuario);
        return new ResponseEntity<String>("{\"result\" : \"OK\"}", HttpStatus.OK);
    }

  }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> deleteUser(@PathVariable String id) {
        Long idLong = Long.parseLong(id); 
        userRepository.deleteById(idLong);
        return ResponseEntity.noContent().build();
    }
   
    //Actualizar todos los parámetros de un usuario
    @PutMapping("/usuarios")
    public ResponseEntity<Usuario> updateUser( @RequestBody Usuario usuario) {
        Usuario newUsuario = userRepository.save(usuario);
        if (newUsuario == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok().body(newUsuario);
    }
 
    
}