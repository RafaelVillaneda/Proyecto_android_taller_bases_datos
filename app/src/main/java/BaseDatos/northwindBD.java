package BaseDatos;

import androidx.room.Database;

import Edntidades.clientes;

@Database(entities = {clientes.class},version =1,exportSchema = false)
public class northwindBD {

}
