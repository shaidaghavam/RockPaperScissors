package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    TextView userSelectionTextview, compSelectionTextview, wonLostTie, scoreTextview;
    int userScore = 0, compScore = 0;

    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userSelectionTextview = findViewById(R.id.playerTxt);
        compSelectionTextview = findViewById(R.id.nameTxt);
        wonLostTie = findViewById(R.id.wonLostTieTxt);
        scoreTextview = findViewById(R.id.scoreTxt);

        userSelectionTextview.setText("");
        wonLostTie.setText("");


        random = new Random();


    }


    public void resetButton(View view) {
        userSelectionTextview.setText("");
        compSelectionTextview.setText("");
        wonLostTie.setText("");
        userScore =0;
        compScore=0;
        setScoreTextView(userScore,compScore);




    }

    public void rpsButtonSelected(View view) {

        int userSelection = Integer.parseInt(view.getTag().toString());
        Log.i(TAG, "rpsButtonSelected" + userSelection);
        matchGame(userSelection);

    }

    private void matchGame(int userSelection) {

        int low = 1;
        int high = 3;

        int compSelection = random.nextInt(high) + low;

        if (userSelection == compSelection) {
            wonLostTie.setText("Tie");
            //Tie
        } else if ((userSelection - compSelection) % 3 == 1) {
            userScore++;
            wonLostTie.setText("Win");

            //User Win
        } else {
            compScore++;
            wonLostTie.setText("Lost");

            //Comp win
        }
        switch (userSelection) {
            case 1:
                userSelectionTextview.setText("Rock");
                break;

            case 2:
                userSelectionTextview.setText("Paper");
                break;

            case 3:
                userSelectionTextview.setText("Scissor");
                break;


        }

        switch (compSelection) {
            case 1:
                compSelectionTextview.setText("Rock");
                break;

            case 2:
                compSelectionTextview.setText("Paper");
                break;

            case 3:
                compSelectionTextview.setText("Scissor");
                break;
        }
        setScoreTextView(userScore,compScore);
    }

        private void setScoreTextView(int userScore,int compScore){

            scoreTextview.setText(String.valueOf(userScore) + " : " + String.valueOf(compScore));
        }
    }

