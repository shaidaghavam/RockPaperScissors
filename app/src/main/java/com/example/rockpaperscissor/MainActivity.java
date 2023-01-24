package com.example.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    TextView scoreTextview;
    int Score = 0,compScore;
    Button Rock, paper, scissors;
    ImageView userSelection, compSelection;

    //Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        scoreTextview = findViewById(R.id.scoreTxt);
        Rock = (Button) findViewById(R.id.rockButton);
        paper = (Button) findViewById(R.id.paperButton);
        scissors = (Button) findViewById(R.id.ScissorsButton);
        // userSelection=(ImageView)  findViewById(R.id)


        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userSelection.setImageResource(R.drawable.email);
                String message = play_turn("Paper");
                Intent reg_intent = new Intent( MainActivity.this, MainActivity.class);
                startActivity(reg_intent);
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
                scoreTextview.setText(Integer.toString(Score)+ Integer.toString(compScore));



            }
        });

        Rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userSelection.setImageResource(R.drawable.stones);
                String message = play_turn("Rock");
                Intent reg_intent = new Intent( MainActivity.this, MainActivity.class);
                startActivity(reg_intent);
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
                scoreTextview.setText(Integer.toString(Score)+ Integer.toString(compScore));

            }
        });


        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userSelection.setImageResource(R.drawable.scissorsdraw);
                 String message = play_turn("Scissor");
                Intent reg_intent = new Intent( MainActivity.this, MainActivity.class);
                startActivity(reg_intent);
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
                scoreTextview.setText(Integer.toString(Score)+ Integer.toString(compScore));


            }
        });

        //  random = new Random();


    }

    public String play_turn(String player_choice) {
        String computer_choice = "";
        Random random = new Random();
        int computerChoiceNumber = random.nextInt(3) + 1;

        if (computerChoiceNumber == 1) {
            computer_choice = "Rock";
        } else if (computerChoiceNumber == 2) {

            computer_choice = "Scissor";
        } else if (computerChoiceNumber == 3) {
            computer_choice = "Paper";
        }
        if (computer_choice == "Rock") {
            compSelection.setImageResource(R.drawable.stones);
        } else if (computer_choice == "Scissor") {
            compSelection.setImageResource(R.drawable.scissorsdraw);

        } else if (computer_choice == "Paper") {
            compSelection.setImageResource(R.drawable.email);


        }
        if (computer_choice == player_choice) {
            return "Tie";

        } else if (player_choice == "Rock" && computer_choice == "Scissor") {
            Score++;
            return "Win";
        }
        else if (player_choice == "Scissor" && computer_choice == "Paper") {
            compScore++;
            return "Lost";
        }

        else if (player_choice == "Scissors" && computer_choice == "Rock") {
            compScore++;
            return "Lost";
        }
        else if (player_choice == "Scissors" && computer_choice == "Paper") {
            Score++;
            return "Win";
        }
        else if (player_choice == "Paper" && computer_choice == "Rock") {
            Score++;
            return "Win";
        }
        else if (player_choice == "Paper" && computer_choice == "Scissor") {
            compScore++;
            return "Lost";
        }
        else return "Something is wrong";
   /* public void rpsButtonSelected(View view) {

         int userSelection = Integer.parseInt(view.getTag().toString());
        Log.i(TAG, "rpsButtonSelected" + userSelection);
        matchGame(userSelection);

    }*/

   /* private void matchGame(int userSelection) {

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

        }*/


    }
}

