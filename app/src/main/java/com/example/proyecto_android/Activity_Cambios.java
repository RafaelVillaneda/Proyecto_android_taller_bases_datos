package com.example.proyecto_android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;

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
        caja_ciudad=findViewById(R.id.caja_direccion_cambios);
        caja_region=findViewById(R.id.caja_region_cambios);
        caja_codigo_postal=findViewById(R.id.caja_codigo_postal_cambios);
        caja_pais=findViewById(R.id.caja_pais_cambios);
        caja_telefono=findViewById(R.id.caja_telefono_cambios);
        caja_fax=findViewById(R.id.caja_fax_cambios);
    }



}
