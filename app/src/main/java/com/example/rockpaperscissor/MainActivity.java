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

    TextView scoreTextview,compScoreTxt;
    int Score = 0, compScore=0;
    Button Rock, paper, scissors;
    ImageView userSelection, compSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        scoreTextview =(TextView) findViewById(R.id.scoreTxt);
        compScoreTxt= (TextView) findViewById(R.id.userscoreTxt);
        Rock = (Button) findViewById(R.id.rockButton);
        paper = (Button) findViewById(R.id.paperButton);
        scissors = (Button) findViewById(R.id.ScissorsButton);
        userSelection=(ImageView)  findViewById(R.id.userSelection);
        compSelection=(ImageView) findViewById(R.id.compSelection);


        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userSelection.setImageResource(R.drawable.email);
                String message = play_turn("Paper");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                scoreTextview.setText(Integer.toString(Score) );
                compScoreTxt.setText(Integer.toString(compScore));
            }
        });

        Rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userSelection.setImageResource(R.drawable.stones);
                String message = play_turn("rock");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                scoreTextview.setText(Integer.toString(Score) );
                compScoreTxt.setText(Integer.toString(compScore));


            }
        });

        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userSelection.setImageResource(R.drawable.scissorsdraw);
                String message = play_turn("Scissor");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                scoreTextview.setText(Integer.toString(Score));
                compScoreTxt.setText(Integer.toString(compScore));



            }
        });



    }

    public String play_turn(String player_choice) {
        String computer_choice = "";
        Random random = new Random();
        int computerChoiceNumber = random.nextInt(3) + 1;

        if (computerChoiceNumber == 1) {
            computer_choice = "rock";
        } else if (computerChoiceNumber == 2) {

            computer_choice = "Scissor";
        } else if (computerChoiceNumber == 3) {
            computer_choice = "Paper";
        }
        if (computer_choice == "rock") {
            compSelection.setImageResource(R.drawable.stones);
        } else if (computer_choice == "Scissor") {
            compSelection.setImageResource(R.drawable.scissorsdraw);

        } else if (computer_choice == "Paper") {
            compSelection.setImageResource(R.drawable.email);


        }
        if (computer_choice == player_choice) {
            return "Tie";

        } else if (player_choice == "rock" && computer_choice == "Scissor") {
            Score++;
            return "Win";
        } else if (player_choice == "Scissor" && computer_choice == "Paper") {
            Score++;
            return "Win";
        } else if (player_choice == "Scissor" && computer_choice == "rock") {
            compScore++;
            return "Lost";
        } else if (player_choice == "Paper" && computer_choice == "rock") {
            Score++;
            return "Win";
        } else if (player_choice == "Paper" && computer_choice == "Scissor") {
            compScore++;
            return "Lost";
        } else if (player_choice == "rock" && computer_choice == "Paper") {
            compScore++;
            return "Lost";
        } else if (player_choice == "Scissor" && computer_choice == "rock") {
            compScore++;
            return "Lost";
        } else
            return "Something is wrong";
    }
    }