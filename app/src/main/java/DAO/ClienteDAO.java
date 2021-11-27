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
    @Query("UPDATE clientes SET nombreCompañia=:q,nombreContacto=:w,tituloContacto=:e,direccion=:r,ciudad=:t,region=:y,codigoPostal=:u,pais=:i,telefono=:o,fax=:p " +
                            "WHERE id_cliente=:a")
    public void modificar(String q, String w,String e,String r,String t,String y,String u,String i,String o,String p,String a);

    //Consultas
    @Query("SELECT * FROM clientes")
    public List<clientes> optenerTodos();

    @Query("SELECT * FROM clientes WHERE id_cliente LIKE :c")
    public List<clientes> optenerPorFiltrado(String c);

    //Biuscar uno solo
    @Query("SELECT * FROM clientes WHERE id_cliente=:c")
    public clientes optenerUno(String c);

}
