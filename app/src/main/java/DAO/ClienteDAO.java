package DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import Edntidades.clientes;

@Dao
public interface ClienteDAO {

    //Altas
    @Insert
    public void insertCliente(clientes cliente);

    //Bajas
    @Query("DELETE FROM clientes WHERE id_cliente=:id")
    public void eliminarCliente(String id);

    //Cambios

    //Consultas
    @Query("SELECT * FROM clientes")
    public List<clientes> buscarTodos();



}
