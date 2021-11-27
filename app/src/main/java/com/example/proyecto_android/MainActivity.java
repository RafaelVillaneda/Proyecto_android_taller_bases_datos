package com.example.proyecto_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import BaseDatos.northwindBD;
import Edntidades.Usuario;

public class MainActivity extends AppCompatActivity {
    EditText cajaUser,cajaContra;
    boolean exito=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cajaUser=findViewById(R.id.caja_usuario);
        cajaContra=findViewById(R.id.caja_contra);
    }
    public void btn_ingresar(View a){
        Usuario usu=new Usuario(cajaUser.getText().toString(),cajaContra.getText().toString());
        new Thread(new Runnable() {
            @Override
            public void run() {
                northwindBD conexion = northwindBD.gettAppDatabase(getBaseContext());
                //conexion.usuarioDAO().insertarUsuario(new Usuario("rafa","rafaferrari01"));
                Usuario usu2 = conexion.usuarioDAO().buscarUsuario(cajaUser.getText().toString());
                if (!(cajaUser.getText().toString().isEmpty() && cajaContra.getText().toString().isEmpty()) && usu2!=null){
                    if (usu.getUser().equals(usu2.getUser()) && usu.getContraseña().equals(usu2.getContraseña())) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getBaseContext(), "Bienvenido " + usu.getUser().toString(), Toast.LENGTH_LONG).show();
                                exito=true;
                            }
                        });
                    } else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getBaseContext(), "Lo siento el usuario o la contraseña estan incorrectas", Toast.LENGTH_LONG).show();
                                exito=false;
                            }
                        });
                    }
            }else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getBaseContext(), "Lo siento el usuario o la contraseña estan incorrectas", Toast.LENGTH_LONG).show();
                            exito=false;
                        }
                    });

                }
            }
        }).start();
        if(exito==true) {
            Intent i = new Intent(this, activityMenu.class);
            startActivity(i);
        }
    }
}