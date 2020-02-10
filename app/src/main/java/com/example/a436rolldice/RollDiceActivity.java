package com.example.a436rolldice;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.media.Image;
import android.os.Bundle;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;


import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class RollDiceActivity extends AppCompatActivity {

    ImageView Dice_1, Dice_4; //I messed up and it become dice 4

    ImageView[] diceArray = {};
    private Random rng = new Random();



    private Button RollDice;
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


        RollDice = (Button) findViewById(R.id.RollDice);

        RollDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeDiceFace();// We dont need 2 functions for both faces, just one function that will change the faces of both dice
                changeDiceFace2();
            }
        });

    }

    private void changeDiceFace(){

        int randomNumber = rng.nextInt(6) + 1;



        switch(randomNumber){
            case 1:
                Dice_1.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                Dice_1.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                Dice_1.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                Dice_1.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                Dice_1.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                Dice_1.setImageResource(R.drawable.dice_6);
                break;


        }

    }

    private void changeDiceFace2(){

        int randomNumber = rng.nextInt(6) + 1;



        switch(randomNumber){
            case 1:
                Dice_4.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                Dice_4.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                Dice_4.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                Dice_4.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                Dice_4.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                Dice_4.setImageResource(R.drawable.dice_6);
                break;


        }

    }
}
