package com.example.android.primefactors;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showAlert(View view) {
        int vnes;
        EditText txtBox = (EditText) findViewById(R.id.txtInput);
        vnes = Integer.valueOf(txtBox.getText().toString());
        List<Integer> list = new ArrayList<Integer>();
        while (vnes != 1) {
            for (Integer brojach = 2; brojach <= vnes; brojach++) {
                if (vnes % brojach == 0) {

                    list.add(brojach);

                    vnes = vnes / brojach;
                    brojach -= 1;

                }
            }





        }
        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage("The prime factors of the entered number are: " + Arrays.toString(list.toArray())) .create();
        myAlert.show();
    }
}