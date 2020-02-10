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

        RollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                changeDiceFace();// We dont need 2 functions for both faces, just one function that will change the faces of both dice

                if(turnTotal < 50){
                    Turn_Total.setText("Turn total: " + turnTotal);
                }
                else if (turnTotal >= 50){

                }

            }
        });

        holdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hold_Button();
            }
        });

    }

    private void changeDiceFace(){

        int randomNumber = rng.nextInt(6) + 1;
        int randomNumber2 = rng.nextInt(6) + 1;

        boolean isOne = false, isOne2 = false;



        switch(randomNumber){
            case 1:
                Dice_1.setImageResource(R.drawable.dice_1);
                isOne = true;
                turnTotal += 1;
                break;
            case 2:
                Dice_1.setImageResource(R.drawable.dice_2);
                turnTotal += 2;
                break;
            case 3:
                Dice_1.setImageResource(R.drawable.dice_3);
                turnTotal += 3;
                break;
            case 4:
                Dice_1.setImageResource(R.drawable.dice_4);
                turnTotal += 4;
                break;
            case 5:
                Dice_1.setImageResource(R.drawable.dice_5);
                turnTotal += 5;
                break;
            case 6:
                Dice_1.setImageResource(R.drawable.dice_6);
                turnTotal += 6;
                break;


            }
        switch(randomNumber2){
            case 1:
                Dice_4.setImageResource(R.drawable.dice_1);
                isOne2 = true;
                turnTotal += 1;
                break;
            case 2:
                Dice_4.setImageResource(R.drawable.dice_2);
                turnTotal += 2;
                break;
            case 3:
                Dice_4.setImageResource(R.drawable.dice_3);
                turnTotal += 3;
                break;
            case 4:
                Dice_4.setImageResource(R.drawable.dice_4);
                turnTotal += 4;
                break;
            case 5:
                Dice_4.setImageResource(R.drawable.dice_5);
                turnTotal += 5;
                break;
            case 6:
                Dice_4.setImageResource(R.drawable.dice_6);
                turnTotal += 6;
                break;


        }

        if(isOne && isOne2){

            turnTotal = 0;
            Turn_Total.setText("Turn total: " + turnTotal);

        }


    }



    private void Hold_Button(){

        turnTotal = 0;

        Turn_Total.setText("Turn total: 0");



    }
}
