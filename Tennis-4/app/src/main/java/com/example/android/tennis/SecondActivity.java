package com.example.android.tennis;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Random;


public class SecondActivity extends AppCompatActivity
{

    private Button pauseButton;
    private TextView lblPlayer1points;
    private TextView lblPlayer2points;
    private TextView lblset1Player1Games;
    private TextView lblset1Player2Games;
    private TextView lblset2Player1Games;
    private TextView lblset2Player2Games;
    private TextView lblset3Player1Games;
    private TextView lblset3Player2Games;
    private TextView lblset4Player1Games;
    private TextView lblset4Player2Games;
    private TextView lblset5Player1Games;
    private TextView lblset5Player2Games;
    private TextView lblPlayerToServe;
    private RadioButton player1ToServe;
    private RadioButton player2ToServe;
    private Handler pointPlayHandler = new Handler();
    private int pointPlayTimerSpeed = 1000;
    private int randomPointRange = 18;
    private int player1ServiceStr = 8;
    private int player2ServiceStr = 8;
    private String player1Points = "0";
    private String player2Points = "0";
    private int player1PointsTieBreak = 0;
    private int player2PointsTieBreak = 0;
    private int player1Game = 0;
    private int player2Game = 0;
    private String playerToServe;
    private String pointPlayType = "Regular";
    private int player1Set = 0;
    private int player2Set = 0;
    private int setPlayed = 1;
    private int tieBreakPontPlayed = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        playerToServe = "PLAYER1";

        lblPlayer1points = (TextView) findViewById(R.id.lblPlayer1points);
        lblPlayer2points = (TextView) findViewById(R.id.lblPlayer2points);

        lblset1Player1Games = (TextView) findViewById(R.id.lblset1Player1Games);
        lblset1Player2Games = (TextView) findViewById(R.id.lblset1Player2Games);

        lblset2Player1Games = (TextView) findViewById(R.id.lblset2Player1Games);
        lblset2Player2Games = (TextView) findViewById(R.id.lblset2Player2Games);

        lblset3Player1Games = (TextView) findViewById(R.id.lblset3Player1Games);
        lblset3Player2Games = (TextView) findViewById(R.id.lblset3Player2Games);

        lblset4Player1Games = (TextView) findViewById(R.id.lblset4Player1Games);
        lblset4Player2Games = (TextView) findViewById(R.id.lblset4Player2Games);

        lblset5Player1Games = (TextView) findViewById(R.id.lblset5Player1Games);
        lblset5Player2Games = (TextView) findViewById(R.id.lblset5Player2Games);

        player1ToServe  = (RadioButton) findViewById(R.id.player1ToServe);
        player2ToServe  = (RadioButton) findViewById(R.id.player2ToServe);
        player1ToServe.setChecked(true);
        player2ToServe.setChecked(false);

        lblPlayerToServe = (TextView) findViewById(R.id.lblPlayerToServe);
        pointPlayHandler.postDelayed(pointPlayrun, pointPlayTimerSpeed);
        pauseButton = (Button) findViewById(R.id.pauseButton);

        lblPlayerToServe.setText("SET "+Integer.toString(setPlayed)+"\nPLAYER 1 SERVING\n"+pointPlayType);

    }

    void btnBackClick(View v)
    {

        Intent startMainActivity = new Intent(this, MainActivity.class);
        startActivity(startMainActivity);
        finish();
        //final TextView player1 = (TextView) findViewById(R.id.textView4) ;
        //animateText(player1);

    }

    void btnPauseClick(View v)
    {
        String pauseText = (String) pauseButton.getText();
        if(pauseText.equals("PAUSE")){
            pauseButton.setText("RESUME");
            pointPlayHandler.removeCallbacks(pointPlayrun);
        }else{
            pauseButton.setText("PAUSE");
            pointPlayHandler.postDelayed(pointPlayrun, pointPlayTimerSpeed);
        }
    }
    void animateText (final TextView textLabel)
    {

        textLabel.animate().scaleXBy(0.52f);
        textLabel.animate().scaleYBy(0.52f);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textLabel.setTextColor(Color.BLACK);
                textLabel.animate().scaleX(1);
                textLabel.animate().scaleY(1);
                //Do something after 100ms
            }
        }, 400);

        textLabel.setTextColor(Color.RED);
    }
    void pointPlayedFunction() {

        int player1PointChance = 0;
        int player2PointChance = 0;

        if(playerToServe.equals("PLAYER1")){
            player1PointChance = new Random().nextInt(randomPointRange)+player1ServiceStr;
            player2PointChance = new Random().nextInt(randomPointRange);
        }else{
            player1PointChance = new Random().nextInt(randomPointRange);
            player2PointChance = new Random().nextInt(randomPointRange)+player2ServiceStr;
        }
        if(pointPlayType.equals("Regular")) {
            if (player1PointChance > player2PointChance) {
                endedRegularPoint("payer1");
            } else if (player2PointChance > player1PointChance) {
                endedRegularPoint("payer2");
            }else if (player2PointChance == player1PointChance) {
                switch (playerToServe){
                    case "PLAYER1":
                        endedRegularPoint("payer1");
                        break;
                    case "PLAYER2":
                        endedRegularPoint("payer2");
                        break;
                }
            }
        }else{
            if (player1PointChance > player2PointChance) {
                endedTieBreakPoint("payer1");
            } else if (player2PointChance > player1PointChance) {
                endedTieBreakPoint("payer2");
            }else if (player2PointChance == player1PointChance) {
                switch (playerToServe){
                    case "PLAYER1":
                        endedTieBreakPoint("payer1");
                        break;
                    case "PLAYER2":
                        endedTieBreakPoint("payer2");
                        break;
                }
            }
        }
        /*if(tmpppp > 0){
            tmpppp = 0;
            endedRegularPoint("payer1");
        }else{
            tmpppp = 1;
            endedRegularPoint("payer2");
        }*/
    }

    private void endedTieBreakPoint(String payerWon) {
        Log.d("point won - ",payerWon);
        switch(payerWon){
            case "payer1":
                player1PointsTieBreak++;
                break;
            case "payer2":
                player2PointsTieBreak++;
                break;
        }
        tieBreakPontPlayed++;
        Log.d("serving - ",playerToServe);
        Log.d("P1 Tie - ",Integer.toString(player1PointsTieBreak));
        Log.d("P2 Tie - ",Integer.toString(player2PointsTieBreak));
        if( (player1PointsTieBreak + player2PointsTieBreak) == 1){
            //FORCE SERVE CHANGE AFTER FIRST TIE BREAK POINT
            tieBreakPontPlayed++;
        }
        if(playerToServe.equals("PLAYER1") && tieBreakPontPlayed == 2){
            lblPlayerToServe.setText("SET "+Integer.toString(setPlayed)+"\nPLAYER 2 SERVING\n"+pointPlayType);
            player2ToServe.setChecked(true);
            player1ToServe.setChecked(false);
            playerToServe = "PLAYER2";
            tieBreakPontPlayed = 0;
        }
        if(playerToServe.equals("PLAYER2") && tieBreakPontPlayed == 2){
            lblPlayerToServe.setText("SET "+Integer.toString(setPlayed)+"\nPLAYER 1 SERVING\n"+pointPlayType);
            player1ToServe.setChecked(true);
            player2ToServe.setChecked(false);
            playerToServe = "PLAYER1";
            tieBreakPontPlayed = 0;
        }
        if((player1PointsTieBreak - player2PointsTieBreak) >= 2 && player1PointsTieBreak  >=7){
            endedGame("payer1");
            player1PointsTieBreak = 0;
            player2PointsTieBreak = 0;
            player1Points = "0";
            player2Points = "0";
            tieBreakPontPlayed = 0;
        }
        if((player2PointsTieBreak - player1PointsTieBreak) >=2 && player2PointsTieBreak  >=7){
            endedGame("payer2");
            player1PointsTieBreak = 0;
            player2PointsTieBreak = 0;
            player1Points = "0";
            player2Points = "0";
            tieBreakPontPlayed = 0;
        }
        lblPlayer1points.setText(Integer.toString(player1PointsTieBreak));
        lblPlayer2points.setText(Integer.toString(player2PointsTieBreak));
    }

    private void endedRegularPoint(String payerWon) {
        Log.d("point won - ",payerWon);
        switch(payerWon){
            case "payer1":
                switch(player1Points){
                    case "0":
                        player1Points = "15";
                        animateText(lblPlayer1points);
                        break;
                    case "15":
                        player1Points = "30";
                        animateText(lblPlayer1points);
                        break;
                    case "30":
                        if(!player2Points.equals("40")){
                            player1Points = "40";
                            animateText(lblPlayer1points);
                        }else{
                            player1Points = "Deuce";
                            player2Points = "Deuce";
                            Log.d("Deuce - ",payerWon);
                            animateText(lblPlayer1points);
                            animateText(lblPlayer2points);
                        }
                        break;
                    case "40":
                        endedGame("payer1");
                        break;
                    case "Deuce":
                        player1Points = "A";
                        player2Points = "";
                        Log.d("Advantage - ",payerWon);
                        animateText(lblPlayer1points);
                        break;
                    case "":
                        player1Points = "Deuce";
                        player2Points = "Deuce";
                        Log.d("Deuce - ",payerWon);
                        animateText(lblPlayer1points);
                        animateText(lblPlayer2points);
                        break;
                    case "A":
                        Log.d("WON - ",payerWon);
                        endedGame("payer1");
                        break;
                }
                break;
            case "payer2":
                switch(player2Points){
                    case "0":
                        player2Points = "15";
                        animateText(lblPlayer2points);
                        break;
                    case "15":
                        player2Points = "30";
                        animateText(lblPlayer2points);
                        break;
                    case "30":
                        if(!player1Points.equals("40")){
                            player2Points = "40";
                            animateText(lblPlayer2points);
                        }else{
                            player2Points = "Deuce";
                            player1Points = "Deuce";
                            Log.d("Deuce - ",payerWon);
                            animateText(lblPlayer1points);
                            animateText(lblPlayer2points);
                        }
                        break;
                    case "40":
                        endedGame("payer2");
                        break;
                    case "Deuce":
                        player2Points = "A";
                        player1Points = "";
                        Log.d("Advantage - ",payerWon);
                        animateText(lblPlayer2points);
                        break;
                    case "":
                        player1Points = "Deuce";
                        player2Points = "Deuce";
                        Log.d("Deuce - ",payerWon);
                        animateText(lblPlayer1points);
                        animateText(lblPlayer2points);
                        break;
                    case "A":
                        Log.d("WON - ",payerWon);
                        endedGame("payer2");
                        break;
                }
                break;
        }

        lblPlayer1points.setText(player1Points);
        lblPlayer2points.setText(player2Points);

    }

    private void endedGame(String payerWonGame) {
        Log.d("game won - ",payerWonGame);
        switch(payerWonGame){
            case "payer1":
                player1Game++;
                break;
            case "payer2":
                player2Game++;
                break;
        }
        player1Points = "0";
        player2Points = "0";
        player1PointsTieBreak = 0;
        player2PointsTieBreak = 0;

        TextView[] lblSetPlayer1Array = {lblset1Player1Games, lblset2Player1Games, lblset3Player1Games, lblset4Player1Games, lblset5Player1Games};
        TextView[] lblSetPlayer2Array = {lblset1Player2Games, lblset2Player2Games, lblset3Player2Games, lblset4Player2Games, lblset5Player2Games};

        if(!lblSetPlayer1Array[setPlayed-1].getText().equals(Integer.toString(player1Game))){
            lblSetPlayer1Array[setPlayed-1].setText(Integer.toString(player1Game));
            animateText(lblSetPlayer1Array[setPlayed-1]);
        }
        if(!lblSetPlayer2Array[setPlayed-1].getText().equals(Integer.toString(player2Game))){
            lblSetPlayer2Array[setPlayed-1].setText(Integer.toString(player2Game));
            animateText(lblSetPlayer2Array[setPlayed-1]);
        }


        if(player1Game >= 6 ||  player2Game >= 6 ){
            if(player1Game == 6 && player2Game == 6){
                pointPlayType = "TieBreak";
                if((setPlayed%2) == 0 ){
                    playerToServe = "PLAYER1";
                }else{
                    playerToServe = "PLAYER2";
                }
            }else if(pointPlayType.equals("TieBreak")){
                endedSet(payerWonGame);
            }else{
                if((player1Game - player2Game) >= 2){
                    endedSet("payer1");
                }
                if((player2Game - player1Game) >= 2){
                    endedSet("payer2");
                }
            }

        }
        if(player1Set < 3 &&player2Set < 3) {
            if (playerToServe.equals("PLAYER1")) {
                lblPlayerToServe.setText("SET "+Integer.toString(setPlayed)+"\nPLAYER 2 SERVING\n"+pointPlayType);
                player2ToServe.setChecked(true);
                player1ToServe.setChecked(false);
                playerToServe = "PLAYER2";
            } else {
                lblPlayerToServe.setText("SET "+Integer.toString(setPlayed)+"\nPLAYER 1 SERVING\n"+pointPlayType);
                player1ToServe.setChecked(true);
                player2ToServe.setChecked(false);
                playerToServe = "PLAYER1";
            }
        }
    }

    private void endedSet(String playerWonSet) {
        switch(playerWonSet){
            case "payer1":
                player1Set++;
                break;
            case "payer2":
                player2Set++;
                break;
        }
        setPlayed++;
        player1Game = 0;
        player2Game = 0;
        if(player1Set == 3){
            lblPlayerToServe.setText("PLAYER 1 WON");
            pointPlayHandler.removeCallbacks(pointPlayrun);
            animateText(lblPlayerToServe);
        }
        if(player2Set == 3){
            lblPlayerToServe.setText("PLAYER 2 WON");
            pointPlayHandler.removeCallbacks(pointPlayrun);
            animateText(lblPlayerToServe);
        }
        if((setPlayed%2) == 0 ){
            playerToServe = "PLAYER1";
        }else{
            playerToServe = "PLAYER2";
        }
        pointPlayType = "Regular";
    }

    private Runnable pointPlayrun = new Runnable() {
        @Override
        public void run() {
            if(player1Set < 3 &&player2Set < 3) {
                pointPlayedFunction();
                pointPlayHandler.postDelayed(this, pointPlayTimerSpeed);
            }
        }
    };
}
