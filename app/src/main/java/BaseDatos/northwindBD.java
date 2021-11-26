package BaseDatos;

import androidx.room.Database;

import Edntidades.Usuario;
import Edntidades.clientes;

@Database(entities = {clientes.class, Usuario.class},version =1,exportSchema = false)
public class northwindBD {

}
