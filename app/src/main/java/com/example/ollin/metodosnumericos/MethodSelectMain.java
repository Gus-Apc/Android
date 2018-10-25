package com.example.ollin.metodosnumericos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MethodSelectMain extends AppCompatActivity {

    //Codigo C++
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    //Cositas de Android

    private Button gaussBtn, bairstowBtn, reglinmultBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_method_select_main);
        gaussBtn = (Button) findViewById(R.id.gausBtn);
        bairstowBtn = (Button)findViewById(R.id.bairstowBtn);
        reglinmultBtn = (Button) findViewById(R.id.linialmultBtn);

        gaussBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGaussActivity();
            }
        });

        bairstowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBairstowActivity();
            }
        });

        reglinmultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegMultActivity();
            }
        });
        /*

        // Example of a call to a native method
        //Llamando una variable obtenida de native-lib.cpp
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());*/
    }

    private void openRegMultActivity() {
        Intent regmulIntent = new Intent(this, RegresionMultipleActivity.class);
        startActivity(regmulIntent);
    }

    private void openBairstowActivity() {
        Intent bairstowIntent = new Intent(this, BairstowActivity.class);
        startActivity(bairstowIntent);
    }

    private void openGaussActivity() {
       Intent gaussIntent = new Intent(this, GaussJordanActivity.class);
       startActivity(gaussIntent);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
