package com.example.nahim.eva1_2_calculadora_datepicker_splash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Calculadora extends AppCompatActivity {
    private TextView _screen;
    private String display="";
    private String currentOperator = "";
    private boolean hasResult = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        _screen = (TextView) findViewById(R.id.edtPantalla);
        _screen.setText(display);
    }

    //Metodo para actualizar la pantalla
    private void updateScreen(){
        _screen.setText(display);
    }

    //Metodo que actualizara la pantalla cuando se presione un numero
    protected void onClickNumber(View view){
        if (hasResult) {
            clear();
            updateScreen();
        }
        Button b = (Button) view;
        display += b.getText();
        updateScreen();
    }

    //Metodo que cambiara el valor a la operacion a realizar
    protected void onClickOperator(View view){
        Button b = (Button) view;
        display += b.getText().toString();
        currentOperator = b.getText().toString();
        updateScreen();
    }

    private void clear(){
        display = "";
        currentOperator = "";
        hasResult=false;

    }

    //Metodo que se ejecutara al presionar el boton C
    protected void onClickClear(View view){
        clear();
        updateScreen();
    }

    private double operate(String a, String b, String op){
        hasResult = true;
        switch (op){
            case "+": return Double.valueOf(a) + Double.valueOf(b);
            case "-": return Double.valueOf(a) - Double.valueOf(b);
            case "*": return Double.valueOf(a) * Double.valueOf(b);
            case "/": try {
              return Double.valueOf(a) / Double.valueOf(b);
            } catch (Exception e){
                    hasResult = false;
                    Log.d("Calc", e.getMessage());
            }
            default: return -1;
        }
    }

    //Metodo que se ejecutara al presionar el boton de igual
    protected void onClickEqual(View view){
        String[] operation = display.split(Pattern.quote(currentOperator));
        if (operation.length < 2) return;

        Double _result = operate(operation[0], operation[1], currentOperator);
        _screen.setText(display + "\n" + String.valueOf(_result));
    }
}
