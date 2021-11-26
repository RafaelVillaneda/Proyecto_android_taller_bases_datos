package BaseDatos;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import DAO.ClienteDAO;
import DAO.UsuariDAO;
import Edntidades.Usuario;
import Edntidades.clientes;

@Database(entities = {clientes.class, Usuario.class},version =1,exportSchema = false)

public abstract class northwindBD extends RoomDatabase {

    public abstract ClienteDAO clienteDAO();
    public abstract UsuariDAO  usuarioDAO();

    private static  northwindBD INSTANCE;

    public static northwindBD gettAppDatabase(Context context){
        if(INSTANCE==null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    northwindBD.class,"@escuela").build();
        }
        return  INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE=null;
    }

}
