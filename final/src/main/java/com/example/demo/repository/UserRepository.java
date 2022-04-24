package com.example.demo.repository;

import com.example.demo.model.Usuario;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Usuario, Long> {
    
    @Query("SELECT * FROM USUARIO WHERE USUARIO.ESTADO= :estado")
    public Iterable<Usuario> getallUsuariosByEstado(String estado);
    

    @Modifying //SIEMPRE PONERLO CUANDO SE MODIFICA LA BASE DE DATOS
    @Query("INSERT INTO USUARIO (ID,CORREO,PASSW) VALUES (:id,:correo,:password)")
    void newUser(Long id, String correo, String password);

    
    //Eliminar
    @Query("DELETE FROM USUARIO WHERE USUARIO.ID = :userId")
    public void eliminarUsuario(String userId);
    

    //Actualizar
    @Query("UPDATE USUARIO SET USUARIO.ESTADO= :estado WHERE USUARIO.ID = :Id")
    public Usuario updateUsuarioEstado(String userEstado,String userId);
    
}
