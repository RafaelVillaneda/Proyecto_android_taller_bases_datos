package com.example.proyecto_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class activityMenu extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void abrirActivitis(View v){
        Intent i=null;
        switch (v.getId()) {
            case R.id.btn_agregar_cliente_menu:
                i=new Intent(this,Activity_Altas.class);
                break;
            case R.id.btn_borrar_cliente_menu:
                i=new Intent(this,Activity_Bajas.class);
                break;
            case R.id.btn_modificaciones_menu:

                break;
            case R.id.btn_consultas_menu:
                i=new Intent(this,Activity_Consultas.class);
                break;
        }
        startActivity(i);
    }
}
