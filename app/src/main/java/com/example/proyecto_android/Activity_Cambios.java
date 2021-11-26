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
        caja_indentificador=findViewById(R.id.caja_indentificador_altas);
        caja_nombre_conpañia=findViewById(R.id.caja_nombre_compañia_altas);
        caja_nombre_contacto=findViewById(R.id.caja_nombre_contacto_altas);
        caja_titulo_contacto=findViewById(R.id.caja_titulo_contacto_altas);
        caja_direccion=findViewById(R.id.caja_direccion_altas);
        caja_ciudad=findViewById(R.id.caja_direccion_altas);
        caja_region=findViewById(R.id.caja_region_altas);
        caja_codigo_postal=findViewById(R.id.caja_codigo_postal_altas);
        caja_pais=findViewById(R.id.caja_pais_altas);
        caja_telefono=findViewById(R.id.caja_telefono_altas);
        caja_fax=findViewById(R.id.caja_fax_altas);
    }



}
