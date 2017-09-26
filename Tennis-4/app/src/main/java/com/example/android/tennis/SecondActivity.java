package com.example.android.tennis;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }

    void btnBackClick(View v) {

//        Intent startMainActivity = new Intent(this, MainActivity.class);
//        startActivity(startMainActivity);
//        finish();
        final TextView player1 = (TextView) findViewById(R.id.textView4) ;
        animateText(player1);

    }

    void animateText (final TextView textLabel)
    {
        textLabel.animate().scaleXBy(0.32f);
        textLabel.animate().scaleYBy(0.32f);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textLabel.setTextColor(Color.BLACK);
                textLabel.animate().scaleX(1);
                textLabel.animate().scaleY(1);
                //Do something after 100ms
            }
        }, 300);

        textLabel.setTextColor(Color.RED);
    }

}
