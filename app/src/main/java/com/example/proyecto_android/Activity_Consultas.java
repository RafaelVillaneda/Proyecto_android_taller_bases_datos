package com.example.proyecto_android;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import BaseDatos.northwindBD;
import Edntidades.clientes;

public class Activity_Consultas extends Activity {
    EditText id;
    RecyclerView recicler;
    RecyclerView.Adapter adaper;
    RecyclerView.LayoutManager layoutManager;
    List<clientes> e;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);
        id=findViewById(R.id.caja_consultas);
        recicler=findViewById(R.id.reciclerView);
    }


    public void buscar(View v){
        String[] datos = {""};
        int[] c = new int[1];
        final String[][] cad = {null};
        if(id.getText().toString().isEmpty()){
            //---------------------Recycler View
            recicler.setHasFixedSize(true);

            layoutManager=new LinearLayoutManager(this);

            recicler.setLayoutManager(layoutManager);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    northwindBD conexion=northwindBD.gettAppDatabase(getBaseContext());
                    e= conexion.clienteDAO().optenerTodos();
                    System.out.println("Hola");
                    //System.out.println("Tamaño----------------->"+e.size());
                    c[0] =e.size();
                    for (clientes a:e) {
                        Log.d("datos->",a.toString());
                    }
                    for(int i=0;i<c[0];i++){
                        datos[0] = datos[0]+e.get(i)+"/";
                    }
                    //System.out.println(Arrays.toString(datos));

                    //System.out.println("Tamaño----------------->"+e);
                    adaper=new AdaptadorRegistros(datos[0].split("/"));
                    recicler.setAdapter(adaper);

                }
            }).start();


        }else {
            //---------------------Recycler View
            recicler.setHasFixedSize(true);

            layoutManager=new LinearLayoutManager(this);

            recicler.setLayoutManager(layoutManager);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    northwindBD conexion=northwindBD.gettAppDatabase(getBaseContext());
                    e= conexion.clienteDAO().optenerPorFiltrado("%"+id.getText().toString()+"%");
                    System.out.println("Hola");
                    //System.out.println("Tamaño----------------->"+e.size());
                    c[0] =e.size();
                    for(int i=0;i<c[0];i++){
                        datos[0] = datos[0]+e.get(i)+"/";
                    }
                    //System.out.println(Arrays.toString(datos));

                    //System.out.println("Tamaño----------------->"+e);
                    adaper=new AdaptadorRegistros(datos[0].split("/"));
                    recicler.setAdapter(adaper);
                }
            }).start();
        }
    }


}

//
class AdaptadorRegistros extends RecyclerView.Adapter<AdaptadorRegistros.MyViewHolder>{

    private String[] mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public MyViewHolder(TextView t) {
            super(t);
            textView = t;
        }
    }

    public AdaptadorRegistros(String [] mDataset){
        this.mDataset = mDataset;
    }

    @NonNull
    @Override
    public AdaptadorRegistros.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView tv = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.textviewreciclerview,
                parent, false);
        MyViewHolder vh = new MyViewHolder(tv);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
