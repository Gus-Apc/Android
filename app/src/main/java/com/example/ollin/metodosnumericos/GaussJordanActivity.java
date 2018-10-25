package com.example.ollin.metodosnumericos;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class GaussJordanActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private GridLayout myLayout;
    Spinner arrSpinner;
    DynamicViewsGJArr dnv;
    Context context;
    //Button calcularBtn;
    ArrayAdapter<String> myAdapter;
    int size = 3;
    //Codigo C++
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("gauss-jordan");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gauss_jordan);
        myLayout = (GridLayout)findViewById(R.id.matrices);
        arrSpinner = (Spinner)findViewById(R.id.arrSize);
        //calcularBtn = (Button)findViewById(R.id.calcularBtn);

        DynamicViewsGJArr dinViewArr;
        //Combobox
        //Combobox para el tamaño del array
        Spinner arrSizCombo = (Spinner) findViewById(R.id.arrSize);

        arrSizCombo.setOnItemSelectedListener(this);
        //Obtenemos los valores que llenaran al combobox
        myAdapter = new ArrayAdapter<String>(GaussJordanActivity.this,
                //Creamos una lista que guarde el spinner y sera llenada con el recurso String tamano que es una lista
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.tamano));
        //Asignamos el tipo de spinner como un dropdown usando un estilo desde android
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Asignamos los datos del adapter al spinner
        arrSizCombo.setAdapter(myAdapter);


        final Button calcularBtn = (Button) findViewById(R.id.calcularBtn);
        calcularBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // la cantidad de edittext es el numero de size que corresponde a los id's
                final EditText editText = findViewById(myLayout.getChildAt(0).getId());
                Toast.makeText(getApplicationContext(), editText.getText(), Toast.LENGTH_LONG).show();
            }
        });



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

        //MATRIZ NxN
        //Creando la matriz de manera dinamica con el valor dado por el combobo
        int tamano = Integer.parseInt(item);
        size = tamano;
        //Mostrar lo seleccionado en le comboboc
        Toast.makeText(parent.getContext(), "Selected : " + item, Toast.LENGTH_LONG).show();


        dnv = new DynamicViewsGJArr(context);
        //View toma dos argumentos, la posicion y donde sera mostrado (displayed)
        for (int i=0;i<tamano;i++){

            for(int j = 0; j<tamano;j++){
                //myLayout.addView(dnv.descriptionTextView(getApplicationContext(),"X" + j),j);
                myLayout.addView(dnv.cantidadesEditText(getApplicationContext(), j),j);
            }
        }

       // myLayout.addView(dnv.descriptionTextView(getApplicationContext(),"Item No. 1"),3);
        //myLayout.addView(dnv.cantidadesEditText(getApplicationContext()),0);
       // myLayout.addView(dnv.extraTextView(getApplicationContext(),"34.00"),5);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
