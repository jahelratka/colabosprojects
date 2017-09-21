package com.example.android.fizzbuzz_3;

import android.support.v7.app.AppCompatActivity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void btnCalculateClick(View view)
    {

        //Declaring variables
        int userInput;
        EditText txtBoxInput = (EditText) findViewById(R.id.txtInput);
        List<String> listFizzBuzz = new ArrayList<>();
        AlertDialog.Builder showAlert = new AlertDialog.Builder(this);

        String inputText = txtBoxInput.getText().toString();


        //Simple alert showing the array contents.

        if (inputText.isEmpty() || inputText.length() == 0 || inputText.equals(""))
        {
            txtBoxInput.setError("Please enter a number.");
        }
        else
            {
                userInput = Integer.valueOf(txtBoxInput.getText().toString());
            if (userInput == 0) {
                txtBoxInput.setError("Enter number bigger than 0!");
            }else{
                //The main calculation goes here
                for (int counter = 1; counter <= userInput; counter++) {
                    if (counter % 3 == 0 && counter % 5 == 0) {
                        listFizzBuzz.add("fizzbuzz");
                    } else if (counter % 3 == 0) {
                        listFizzBuzz.add("fizz");
                    } else if (counter % 5 == 0) {
                        listFizzBuzz.add("buzz");
                    } else {
                        listFizzBuzz.add(String.valueOf(counter));
                    }
                }
                showAlert.setMessage(Arrays.toString(listFizzBuzz.toArray())).create();
                showAlert.show();
            }

        }
    }
}



