package com.example.a436rolldice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private Button Play_Now, Help_Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Play_Now = (Button) findViewById(R.id.PlayNow);
        Help_Button = (Button) findViewById(R.id.help);

        Play_Now.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                    openRollDiceActivity();
            }

        });

        Help_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHelpActivity();
            }
        });
    }

    public void openRollDiceActivity(){
        Intent intent = new Intent(this, RollDiceActivity.class);

        startActivity(intent);
    }

    private void openHelpActivity(){
        Intent intent = new Intent(this, HowToPlay.class);

        startActivity(intent);
    }
}
