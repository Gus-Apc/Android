package com.example.ollin.metodosnumericos;

import android.content.Context;
import android.graphics.Color;
import android.text.InputType;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.cert.LDAPCertStoreParameters;

public class DynamicViewsGJArr {
    public LDAPCertStoreParameters cantidadesEditText;
    Context ctx;

    public DynamicViewsGJArr(Context ctx) {
        this.ctx = ctx;
    }

    //Metodos para crear la matriz


    public TextView descriptionTextView(Context context, String text){
        //Creamos como queremos que sea la view
        final ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //Creando la ventanita de acuerdo al contexto
        final TextView textView =new TextView(context);
        textView.setLayoutParams(lparams);
        //Propiedades del textview
        textView.setTextSize(10);
        textView.setTextColor(Color.rgb(0,0,0));
        textView.setText(" "+text+" ");
        textView.setMaxEms(8);
        return textView;
    }

    public EditText cantidadesEditText(Context context){
        final ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final EditText editText = new EditText(context);
        int id = 0;
        editText.setId(id);
        editText.setMinEms(2);
        editText.setTextColor(Color.rgb(0,0,0));
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        return editText;
    }

    public TextView extraTextView(Context context, String text){
        final ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final TextView textView = new TextView(context);
        textView.setLayoutParams(lparams);
        //TOAST?
        //Toast.makeText(,lparams,Toast.LENGTH_LONG).show();
        //textView.setTextColor(123);
        textView.setText(text);
        return textView;
    }
}
