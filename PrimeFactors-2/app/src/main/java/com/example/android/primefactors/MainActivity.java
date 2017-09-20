package com.example.android.primefactors;

import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
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

    public void btnCalculateClick(View view) {

        //Declaring variables
        int userInput;
        EditText txtBoxInput = (EditText) findViewById(R.id.txtInput);
        List<Integer> listPrimeFactors = new ArrayList<>();
        AlertDialog.Builder showAlert = new AlertDialog.Builder(this);
        String inputText = txtBoxInput.getText().toString();

        //Simple alert showing the array contents.
        if (inputText.isEmpty() || inputText.length() == 0 || inputText.equals("")) {
            txtBoxInput.setError("Empty box");
        } else {
            userInput = Integer.valueOf(txtBoxInput.getText().toString());
            if (userInput < 2) {
                txtBoxInput.setError("There are no prime factors for the entered number!");
            } else {
                //Nested loops for getting the prime factor of the number (userInput)
                while (userInput > 1) {
                    for (Integer counter = 2; counter <= userInput; counter++) {
                        if (userInput % counter == 0) {
                            listPrimeFactors.add(counter);
                            userInput = userInput / counter;
                            counter -= 1;
                        }
                    }
                }
                showAlert.setMessage("The prime factors of the entered number are: " + Arrays.toString(listPrimeFactors.toArray())).create();
                showAlert.show();
            }
        }
    }


    }
