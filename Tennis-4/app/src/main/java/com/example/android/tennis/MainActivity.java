package com.example.android.tennis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void btnStartClick (View view)
    {
        Intent startSecondActivity = new Intent(this, SecondActivity.class);
        startActivity(startSecondActivity);
        finish();


    }

}
