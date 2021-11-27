package com.example.proyecto_android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import BaseDatos.northwindBD;
import Edntidades.clientes;

public class Activity_Cambios extends Activity {
    EditText caja_indentificador,caja_nombre_conpañia,caja_nombre_contacto,caja_titulo_contacto,caja_direccion,caja_ciudad,caja_region,caja_codigo_postal,caja_pais,caja_telefono,caja_fax;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cambios_clientes);
        caja_indentificador=findViewById(R.id.caja_indentificador_cambios);
        caja_nombre_conpañia=findViewById(R.id.caja_nombre_compañia_cambios);
        caja_nombre_contacto=findViewById(R.id.caja_nombre_contacto_cambios);
        caja_titulo_contacto=findViewById(R.id.caja_titulo_contacto_cambios);
        caja_direccion=findViewById(R.id.caja_direccion_cambios);
        caja_ciudad=findViewById(R.id.caja_cuidad_cambios);
        caja_region=findViewById(R.id.caja_region_cambios);
        caja_codigo_postal=findViewById(R.id.caja_codigo_postal_cambios);
        caja_pais=findViewById(R.id.caja_pais_cambios);
        caja_telefono=findViewById(R.id.caja_telefono_cambios);
        caja_fax=findViewById(R.id.caja_fax_cambios);
    }
    public void buscar_cambio(View v){
        if(caja_indentificador.getText().toString().isEmpty()==false){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    clientes cli =null;
                    northwindBD conexion=northwindBD.gettAppDatabase(getBaseContext());
                    cli=conexion.clienteDAO().optenerUno(caja_indentificador.getText().toString());
                    if(cli!=null){
                        caja_indentificador.setText(cli.getId_cliente().toString());
                        caja_nombre_conpañia.setText(cli.getNombreCompañia().toString());
                        caja_nombre_contacto.setText(cli.getNombreContacto().toString());
                        caja_titulo_contacto.setText(cli.getTituloContacto().toString());
                        caja_direccion.setText(cli.getDireccion().toString());
                        caja_ciudad.setText(cli.getCiudad().toString());
                        caja_region.setText(cli.getRegion().toString());
                        caja_codigo_postal.setText(cli.getCodigoPostal().toString());
                        caja_pais.setText(cli.getPais().toString());
                        caja_telefono.setText(cli.getTelefono().toString());
                        caja_fax.setText(cli.getFax().toString());
                    }else{
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getBaseContext(),"El registro NO existe",Toast.LENGTH_LONG).show();

                            }
                        });
                    }
                }
            }).start();


        }else{
            Toast.makeText(getBaseContext(),"La caja del indentificador nu puede estar vacia",Toast.LENGTH_LONG).show();

    }

    }
    public void cambios(View v){
        if(caja_indentificador.getText().toString().isEmpty()==false){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    clientes cli =null;
                    northwindBD conexion=northwindBD.gettAppDatabase(getBaseContext());
                    cli=conexion.clienteDAO().optenerUno(caja_indentificador.getText().toString());
                    if(cli!=null){
                        System.out.println("--------------> "+cli.toString());
                        conexion.clienteDAO().modificar(caja_nombre_conpañia.getText().toString(),
                                caja_nombre_contacto.getText().toString(),
                                caja_titulo_contacto.getText().toString(),
                                caja_direccion.getText().toString(),
                                caja_ciudad.getText().toString(),
                                caja_region.getText().toString(),
                                caja_codigo_postal.getText().toString(),
                                caja_pais.getText().toString(),
                                caja_telefono.getText().toString(),
                                caja_fax.getText().toString(),
                                caja_indentificador.getText().toString());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getBaseContext(),"Registro actualizado correctamente",Toast.LENGTH_LONG).show();

                            }
                        });
                    }else{
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getBaseContext(),"El registro NO existe",Toast.LENGTH_LONG).show();

                            }
                        });
                    }
                }
            }).start();


        }else{
            Toast.makeText(getBaseContext(),"La caja del indentificador nu puede estar vacia",Toast.LENGTH_LONG).show();

        }
    }



}
