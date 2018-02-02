package com.example.android.alifbaa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

// sulaiman

public class MainActivity extends AppCompatActivity {
    ImageView flashCardGame;
    ImageView touchTheLetterGame;
    ImageView alphabetTilesGame;
    ImageView letterTrackingGame;
    ImageView settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flashCardGame = (ImageView) findViewById(R.id._1st_game_button);
        touchTheLetterGame = (ImageView) findViewById(R.id._2nd_game_button);
        alphabetTilesGame = (ImageView) findViewById(R.id._3rd_game_button);
        letterTrackingGame = (ImageView) findViewById(R.id._4th_game_button);
        settings =  findViewById(R.id.settings);
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
                new SettingDialog(MainActivity.this).show();
            }
        });

    }

    public class SettingDialog extends android.app.Dialog implements android.view.View.OnClickListener {
        private Activity c;
        private Button yes;
        TextView text;
        EditText edit;
        int answer, s, d;

        SettingDialog(Activity a) {
            super(a);
            this.c = a;
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.settings_question);
            Random ran = new Random();
            s = ran.nextInt(8) + 1;
            d = ran.nextInt(8) + 1;
            text = findViewById(R.id.first_text);
            edit = findViewById(R.id.answer);
            text.setText(s + " + " + d + " = ");
            text.setTextSize(24);
            yes = findViewById(R.id.btn_yes);
            yes.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_yes:
                    answer = Integer.parseInt(edit.getText().toString());
                    if (answer == s + d) {
                        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                        startActivity(intent);
                    }
                    break;
                default:
                    dismiss();
            }
            dismiss();
        }
    }

}
