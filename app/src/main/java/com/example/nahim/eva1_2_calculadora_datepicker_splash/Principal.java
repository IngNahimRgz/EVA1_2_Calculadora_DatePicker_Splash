package com.example.nahim.eva1_2_calculadora_datepicker_splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {
    Button btnCalculadora, btnDatePicker, btnSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Vinculamos los botones
        btnCalculadora  = (Button) findViewById(R.id.btn_Calculadora);
        btnDatePicker   = (Button) findViewById(R.id.btn_DatePicker);
        btnSplash       = (Button) findViewById(R.id.btn_Splash);
    }

    //Creamos los metodos OnClick para cada boton, el cual lanzara una nueva actividad
    public void onClickCalculadora(View view){
        Intent intentCalculadora = new Intent(this, Calculadora.class);
        startActivity(intentCalculadora);
    }

    public void onClickDatePicker(View view){
        Intent intentDatePicker = new Intent(this, DatePicker.class);
        startActivity(intentDatePicker);
    }

    public void onClickSplash(View view){
        Intent intentSplash = new Intent(this, Splash.class);
        startActivity(intentSplash);
        finish();
    }
}
