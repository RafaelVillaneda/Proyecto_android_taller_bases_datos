package DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import Edntidades.Usuario;

@Dao
public interface UsuariDAO {

    @Query("SELECT * FROM Usuario WHERE user=:n")
    public Usuario buscarUsuario(String n);

    //Altas
    @Insert
    public void insertarUsuario(Usuario alum);



}
