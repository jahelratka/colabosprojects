package com.example.android.factorial;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public int finalValue = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void showAlert (View view) {
        System.out.println("START");

        EditText txt = (EditText) findViewById(R.id.txtInput);
        int amount = Integer.valueOf(txt.getText().toString());

        System.out.println(amount);

       for(int x = amount; x>0; x--)
       {
        finalValue = finalValue *  x;
       }

        System.out.println(finalValue);

        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage(finalValue).create();
        myAlert.show();
    }

}
