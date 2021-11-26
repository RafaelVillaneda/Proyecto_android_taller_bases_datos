package Edntidades;

import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;

public class clientes {
    @NonNull
    @PrimaryKey
    private String id_cliente;
    @NonNull
    private String nombreCompañia;
    @NonNull
    private  String nombreContacto;
    @NonNull
    private String tituloContacto;
    @NonNull
    private String direccion;
    @NonNull
    private String ciudad;
    @NonNull
    private String region;
    @NonNull
    private String codigoPostal;
    @NonNull
    private String pais;
    @NonNull
    private String telefono;
    @NonNull
    private String fax;

    public clientes(@NonNull String id_cliente, @NonNull String nombreCompañia, @NonNull String nombreContacto, @NonNull String tituloContacto, @NonNull String direccion, @NonNull String ciudad, @NonNull String region, @NonNull String codigoPostal, @NonNull String pais, @NonNull String telefono, @NonNull String fax) {
        this.id_cliente = id_cliente;
        this.nombreCompañia = nombreCompañia;
        this.nombreContacto = nombreContacto;
        this.tituloContacto = tituloContacto;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.region = region;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
        this.telefono = telefono;
        this.fax = fax;
    }

    public clientes() {}

    @NonNull
    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(@NonNull String id_cliente) {
        this.id_cliente = id_cliente;
    }

    @NonNull
    public String getNombreCompañia() {
        return nombreCompañia;
    }

    public void setNombreCompañia(@NonNull String nombreCompañia) {
        this.nombreCompañia = nombreCompañia;
    }

    @NonNull
    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(@NonNull String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    @NonNull
    public String getTituloContacto() {
        return tituloContacto;
    }

    public void setTituloContacto(@NonNull String tituloContacto) {
        this.tituloContacto = tituloContacto;
    }

    @NonNull
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(@NonNull String direccion) {
        this.direccion = direccion;
    }

    @NonNull
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(@NonNull String ciudad) {
        this.ciudad = ciudad;
    }

    @NonNull
    public String getRegion() {
        return region;
    }

    public void setRegion(@NonNull String region) {
        this.region = region;
    }

    @NonNull
    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(@NonNull String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @NonNull
    public String getPais() {
        return pais;
    }

    public void setPais(@NonNull String pais) {
        this.pais = pais;
    }

    @NonNull
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(@NonNull String telefono) {
        this.telefono = telefono;
    }

    @NonNull
    public String getFax() {
        return fax;
    }

    public void setFax(@NonNull String fax) {
        this.fax = fax;
    }

    @Override
    public String toString() {
        return "clientes->" +
                ", nombre de la compañia='" + nombreCompañia + '\'' +
                ", nombreContacto='" + nombreContacto + '\'' +
                ", tituloContacto='" + tituloContacto + '\'' +
                '}';
    }
}
