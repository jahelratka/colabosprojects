package com.example.android.primefactors;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showAlert(View view) {
        int brojNaNiza = 0;
        int vnes;
        int[] arrayList = new int[1000];
        String finalValue = "";
        EditText txtBox = (EditText) findViewById(R.id.txtInput);
        vnes = Integer.valueOf(txtBox.getText().toString());

        while (vnes != 1) {

            for (int brojach = 2; brojach <= vnes; brojach++) {
                if (vnes % brojach == 0) {
                    arrayList[brojNaNiza] += brojach;
                    vnes = vnes / brojach;
                    brojach -= 1;
                    brojNaNiza += 1;

                }
            }


            for (int broj = brojNaNiza - 1; broj >= 0; broj--) {
                finalValue += arrayList[broj] + " ";
            }

            AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
            myAlert.setMessage("The prime factors of the entered number are: " + finalValue) .create();
            myAlert.show();
        }
    }
}