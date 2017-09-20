package com.example.android.factorial;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // Initialization of variable needed for looping
    public double finalValue = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //The button event
    public void showAlert (View view)
    {
        //Alert dialog declaration
        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        //Initialize new EditText variable and assign the textbox to it then put the value in a double variable.
        EditText txtBoxInput = (EditText) findViewById(R.id.txtInput);

        String inputText = txtBoxInput.getText().toString();

       //Simple alert which displays the result.
        if (inputText.isEmpty() || inputText.length() == 0 || inputText.equals("")) {
            txtBoxInput.setError("Empty box");
        } else {
            double amount = Double.valueOf(txtBoxInput.getText().toString());
            //The loop for finding the factorial, the result is stored in the variable finalValue.
            for(double x = amount; x>0; x--)
            {
                finalValue *=  x;
            }
            myAlert.setMessage(Double.toString(finalValue)).create();
            myAlert.show();
            //Reset the final value to enable another calculation.
            finalValue = 1;
        }
    }

}
