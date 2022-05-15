package com.example.demo.repository;

import com.example.demo.model.Usuario;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<Usuario, Long> {
    

    @Modifying
    @Query("INSERT INTO USUARIO (ID,CORREO,PASSW) VALUES (:id,:correo,:password)")
    void newUser(Long id, String correo, String password);

    
    @Modifying
    @Query("DELETE FROM USUARIO WHERE USUARIO.ID = :Id")
    public void eliminarUsuario(@Param("Id")String Id);

    @Query("SELECT * FROM USUARIO WHERE USUARIO.CORREO = :MAIL")
    public Usuario getUserByMail(@Param("MAIL")String mail);
    

}
