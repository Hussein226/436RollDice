package com.example.a436rolldice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class RollDiceActivity extends AppCompatActivity {

    ImageView Dice_1, Dice_2, Dice_3, Dice_4, Dice_5, Dice_6;


    private Button RollDice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_dice);

        Dice_1 = (ImageView) findViewById(R.id.Dice1);
        
        RollDice = (Button) findViewById(R.id.RollDice);

    }
}
