package com.example.android.alifbaa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import de.hdodenhof.circleimageview.CircleImageView;
// sulaiman

public class MainActivity extends AppCompatActivity {
    ImageView flashCardGame;
    ImageView touchTheLetterGame;
    ImageView alphabetTilesGame;
    ImageView letterTrackingGame;
    CircleImageView settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flashCardGame = (ImageView) findViewById(R.id._1st_game_button);
        touchTheLetterGame = (ImageView) findViewById(R.id._2nd_game_button);
        alphabetTilesGame = (ImageView) findViewById(R.id._3rd_game_button);
        letterTrackingGame = (ImageView) findViewById(R.id._4th_game_button);
        settings = (CircleImageView) findViewById(R.id.settings);
        flashCardGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FlashCardsActivity.class);
                startActivity(intent);
            }
        });
        touchTheLetterGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TouchTheLetterActivity.class);
                startActivity(intent);

            }
        });
        alphabetTilesGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlphabetTilesActivity.class);
                startActivity(intent);
            }
        });
        letterTrackingGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LetterTrackingActivity.class);
                startActivity(intent);

            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

    }
}
