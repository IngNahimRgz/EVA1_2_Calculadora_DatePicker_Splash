package com.example.nahim.eva1_2_calculadora_datepicker_splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(Splash.this,Principal.class);
        startActivity(intent);
        finish();
    }
}
