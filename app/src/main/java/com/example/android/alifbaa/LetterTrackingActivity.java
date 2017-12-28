package com.example.android.alifbaa;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by brayan pc on 12/4/2017.
 */

public class LetterTrackingActivity extends AppCompatActivity {
    Button eraser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter_tracking);
        Button home = findViewById(R.id.home_button);
        eraser = (Button) findViewById(R.id.erase);
        eraser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog();
            }
        });
    }

    @Override
    public void onBackPressed() {
        dialog();
    }

    public void dialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(LetterTrackingActivity.this);
        dialog.setMessage("Are You Sure, all the progress will be lost?");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        dialog.create().show();
    }
}


