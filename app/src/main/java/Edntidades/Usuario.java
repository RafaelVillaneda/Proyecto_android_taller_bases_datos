package Edntidades;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Usuario {
    @NonNull
    @PrimaryKey
    private String user;
    @NonNull
    private String contraseña;

    public Usuario(String user, String contraseña) {
        this.user = user;
        this.contraseña = contraseña;
    }

    @NonNull
    public String getUser() {
        return user;
    }

    public void setUser(@NonNull String user) {
        this.user = user;
    }

    @NonNull
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(@NonNull String contraseña) {
        this.contraseña = contraseña;
    }
}
