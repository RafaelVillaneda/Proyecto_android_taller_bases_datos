package com.example.proyecto_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import BaseDatos.northwindBD;
import Edntidades.clientes;

public class Activity_Bajas extends AppCompatActivity {
    EditText caja_indentificador,caja_nombre_conpañia,caja_nombre_contacto,caja_titulo_contacto,caja_direccion,caja_ciudad,caja_region,caja_codigo_postal,caja_pais,caja_telefono,caja_fax;
    Button bon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bajas_clientes);
        caja_indentificador=findViewById(R.id.caja_indentificador_bajas);
        caja_nombre_conpañia=findViewById(R.id.caja_nombre_compañia_bajas);
        caja_nombre_contacto=findViewById(R.id.caja_nombre_contacto_bajas);
        caja_titulo_contacto=findViewById(R.id.caja_titulo_contacto_bajas);
        caja_direccion=findViewById(R.id.caja_direccion_bajas);
        caja_ciudad=findViewById(R.id.caja_cuidad_bajas);
        caja_region=findViewById(R.id.caja_region_bajas);
        caja_codigo_postal=findViewById(R.id.caja_codigo_postal_bajas);
        caja_pais=findViewById(R.id.caja_pais_bajas);
        caja_telefono=findViewById(R.id.caja_telefono_bajas);
        caja_fax=findViewById(R.id.caja_fax_bajas);
        bon=findViewById(R.id.btn_borrar2);
    }

    public void buscar(View v){
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
                                vaciarCajas();
                            }
                        });
                    }
                }
            }).start();


        }

    }
    public void borrar(View v){
        if(!caja_indentificador.getText().toString().isEmpty()){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    northwindBD conexion = northwindBD.gettAppDatabase(getBaseContext());
                    if (conexion.clienteDAO().optenerUno(caja_indentificador.getText().toString()) != null){
                        conexion.clienteDAO().eliminarCliente(caja_indentificador.getText().toString());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getBaseContext(), "El registro fue eliminado con exito", Toast.LENGTH_LONG).show();
                            vaciarCajas();
                        }
                    });
                }else{runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getBaseContext(), "El registro NO existe", Toast.LENGTH_LONG).show();
                            vaciarCajas();
                        }
                    });

                    }
                }
            }).start();
        }
    }
    public void vaciarCajas(){
        caja_indentificador.setText("");
        caja_nombre_conpañia.setText("");
        caja_nombre_contacto.setText("");
        caja_titulo_contacto.setText("");
        caja_direccion.setText("");
        caja_ciudad.setText("");
        caja_region.setText("");
        caja_codigo_postal.setText("");
        caja_pais.setText("");
        caja_telefono.setText("");
        caja_fax.setText("");
    }

}
