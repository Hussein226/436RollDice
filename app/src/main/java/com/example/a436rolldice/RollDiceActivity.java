package com.example.a436rolldice;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.media.Image;
import android.os.Bundle;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;


import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class RollDiceActivity extends AppCompatActivity {

    ImageView Dice_1, Dice_4; //I messed up and it become dice 4

    TextView Player1_Score, Player2_Score, Current_Player, Turn_Total;

    int player1Score,player2Score,turnTotal;
    String currentPlayer;

    int diceTotal, totalScore;

    ImageView[] diceArray = {};
    private Random rng = new Random();





    private Button RollDice, holdButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_dice);

        Dice_1 = (ImageView) findViewById(R.id.Dice1);
        Dice_4 = (ImageView) findViewById(R.id.Dice4);
        boolean SetUp = true;


//        diceArray[0] = Dice_1;
//        diceArray[1] = Dice_2;
//        diceArray[2] = Dice_3;
//        diceArray[3] = Dice_4;
//        diceArray[4] = Dice_5;
//        diceArray[5] = Dice_6;
        // We dont need all of these but maybe store Dice 1 and Dice 2 in an array

        //Button Initializing
        RollDice = (Button) findViewById(R.id.RollDice);
        holdButton = (Button) findViewById(R.id.hold);

        //TextView Initializing
        Player1_Score = (TextView) findViewById(R.id.player1);
        Player2_Score = (TextView) findViewById(R.id.player2);
        Current_Player = (TextView) findViewById(R.id.currPlayer);
        Turn_Total = (TextView) findViewById(R.id.turnTotal);



        setUpGame();

        RollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                changeDiceFace();
                checkWinner();

            }
        });

        holdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hold_Button();
            }
        });

    }

    private void setUpGame(){
        TextView[] players = new TextView[2];

        player1Score = 0;
        player2Score = 0;
        players[0] = Player1_Score;
        players[1] = Player2_Score;

        Random randomStart = new Random();

        int randomNum = randomStart.nextInt(2)+0;




        Player1_Score.setText("Player 1 total: " + player1Score);
        Player2_Score.setText("Player 2 total: " + player2Score);
        Turn_Total.setText("Turn total: " + turnTotal);

        if(players[randomNum].equals(Player1_Score)){
            currentPlayer = "Player 1";
            Current_Player.setText("Current Player: " + currentPlayer);

        }
        else if(players[randomNum].equals(Player2_Score)){
            currentPlayer = "Player 2";
            Current_Player.setText("Current Player: " + currentPlayer);


        }


        System.out.println("Being called again");






    }

    private void changeDiceFace(){

        int randomNumber = rng.nextInt(6) + 1;
        int randomNumber2 = rng.nextInt(6) + 1;

        boolean isOne = false, isOne2 = false, bothOne = false;

        int dice1 = 101, dice2 = 100;
        boolean bothFaces = false;

        holdButton.setEnabled(true);

        switch(randomNumber){
            case 1:
                Dice_1.setImageResource(R.drawable.dice_1);
                isOne = true;
                dice1 = 1;
                turnTotal += 1;
                break;
            case 2:
                Dice_1.setImageResource(R.drawable.dice_2);
                dice1 = 2;
                turnTotal += 2;
                break;
            case 3:
                Dice_1.setImageResource(R.drawable.dice_3);
                dice1 = 3;
                turnTotal += 3;
                break;
            case 4:
                Dice_1.setImageResource(R.drawable.dice_4);
                dice1 = 4;
                turnTotal += 4;
                break;
            case 5:
                Dice_1.setImageResource(R.drawable.dice_5);
                dice1 = 5;
                turnTotal += 5;
                break;
            case 6:
                Dice_1.setImageResource(R.drawable.dice_6);
                dice1 = 6;
                turnTotal += 6;
                break;


            }
        switch(randomNumber2){
            case 1:
                Dice_4.setImageResource(R.drawable.dice_1);
                isOne2 = true;
                dice2 = 1;
                turnTotal += 1;
                break;
            case 2:
                Dice_4.setImageResource(R.drawable.dice_2);
                dice2 = 2;
                turnTotal += 2;
                break;
            case 3:
                Dice_4.setImageResource(R.drawable.dice_3);
                dice2 = 3;
                turnTotal += 3;
                break;
            case 4:
                Dice_4.setImageResource(R.drawable.dice_4);
                dice2 = 4;
                turnTotal += 4;
                break;
            case 5:
                Dice_4.setImageResource(R.drawable.dice_5);
                dice2 = 5;
                turnTotal += 5;
                break;
            case 6:
                Dice_4.setImageResource(R.drawable.dice_6);
                dice2 = 6;
                turnTotal += 6;
                break;


        }

        if(dice1 == dice2){
            if(!(dice1 == 1 && dice2 == 1)){
                bothFaces = true;
            }
        }




        if(bothFaces) {
            if (currentPlayer.equals("Player 1")) {
                turnTotal += player1Score;
                player1Score = 0;
                Turn_Total.setText("Turn total: " + turnTotal);
            } else if (currentPlayer.equals("Player 2")) {
                turnTotal += player2Score;
                player2Score = 0;
                Turn_Total.setText("Turn total: " + turnTotal);
            }

            holdButton.setEnabled(false);
        }
        else if(isOne && isOne2){
            bothOne = true;
            turnTotal = 0;
            Turn_Total.setText("Turn total: " + turnTotal);
            resetPlayerScore();
            changePlayer();

        }
        else if (!bothOne &&(isOne || isOne2)){
            turnTotal = 0;
            Turn_Total.setText("Turn total: " + turnTotal);
            changePlayer();

        }


    }

    private void checkWinner(){

        if(player1Score >= 50){
            System.out.println("Player 1 wins!");
        }
        else if(player2Score >= 50){
            System.out.println("Player 2 wins!");
        }

    }

    private void changePlayer(){

        if(currentPlayer.equals("Player 1")){
            currentPlayer = "Player 2";
            Current_Player.setText("Current player: " + currentPlayer);
        }
        else if(currentPlayer.equals("Player 2")){
            currentPlayer = "Player 1";
            Current_Player.setText("Current player: " + currentPlayer);
        }
    }

    private void Hold_Button(){


        Turn_Total.setText("Turn total: 0");

        if(currentPlayer.equals("Player 1")){
                player1Score += turnTotal;
                updateScore();
                changePlayer();
                System.out.println(currentPlayer);


        }
        else if(currentPlayer.equals("Player 2")){
                player2Score += turnTotal;
                updateScore();
                changePlayer();
                System.out.println(currentPlayer);


        }

        turnTotal = 0;



    }

    private void updateScore(){

        if(currentPlayer.equals("Player 1")){
            Player1_Score.setText("Player 1 total: " + player1Score);

        }
        if(currentPlayer.equals("Player 2")){
            Player2_Score.setText("Player 2 total: " + player2Score);
        }

    }

    private void resetPlayerScore(){

        if(currentPlayer.equals("Player 1")){
            player1Score = 0;

            Player1_Score.setText("Player 1 total: " + player1Score);
        }
        else if(currentPlayer.equals("Player 2")){

            player2Score = 0;

            Player2_Score.setText("Player 2 total: " + player2Score);
        }

    }
}
