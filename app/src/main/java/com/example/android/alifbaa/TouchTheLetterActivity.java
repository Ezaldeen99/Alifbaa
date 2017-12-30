package com.example.android.alifbaa;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class TouchTheLetterActivity extends AppCompatActivity {
    Button homeButton;

    ImageView questionLetterImg;
    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;

    MediaPlayer touchTheVoice;
    MediaPlayer letterVoice;
    MediaPlayer wrongVoice;

    int i = 0;

    ImageView[] imageViews = new ImageView[4];
    Letter[] letters = {new Letter(1, R.drawable.letter_a, R.drawable.animal_a, R.drawable.spelling_a,
            R.string.alif, R.string.arnab, R.raw.letter_1, R.raw.obj_1),
            new Letter(2, R.drawable.letter_b, R.drawable.animal_b, R.drawable.spelling_b,
                    R.string.baa, R.string.duck, R.raw.letter_2, R.raw.obj_2),
            new Letter(3, R.drawable.letter_c, R.drawable.animal_c, R.drawable.spelling_c,
                    R.string.taa, R.string.crocodile, R.raw.letter_3, R.raw.obj_3),
            new Letter(4, R.drawable.letter_d, R.drawable.animal_d, R.drawable.spelling_d,
                    R.string.thaa, R.string.fox, R.raw.letter_4, R.raw.obj_4),
            new Letter(5, R.drawable.letter_e, R.drawable.animal_e, R.drawable.spelling_e,
                    R.string.jeem, R.string.camel, R.raw.letter_5, R.raw.obj_5),
            new Letter(6, R.drawable.letter_f, R.drawable.animal_f, R.drawable.spelling_f,
                    R.string.haa, R.string.horse, R.raw.letter_6, R.raw.obj_6),
            new Letter(7, R.drawable.letter_g, R.drawable.animal_g, R.drawable.spelling_g,
                    R.string.khaa, R.string.kharoof, R.raw.letter_7, R.raw.obj_7),
            new Letter(8, R.drawable.letter_h, R.drawable.animal_h, R.drawable.spelling_h,
                    R.string.daal, R.string.bear, R.raw.letter_8, R.raw.obj_8),
            new Letter(9, R.drawable.letter_i, R.drawable.animal_i, R.drawable.spelling_i,
                    R.string.dhaad, R.string.housefly, R.raw.letter_9, R.raw.obj_9),
            new Letter(10, R.drawable.letter_j, R.drawable.animal_j, R.drawable.spelling_j,
                    R.string.raa, R.string.raccoon, R.raw.letter_10, R.raw.obj_10),
            new Letter(11, R.drawable.letter_k, R.drawable.animal_k, R.drawable.spelling_k,
                    R.string.zaa, R.string.giraffe, R.raw.letter_11, R.raw.obj_11)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_the_letter);

        homeButton = findViewById(R.id.home_button);
        questionLetterImg = findViewById(R.id.question_letter_img);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);

        imageViews[0] = image1;
        imageViews[1] = image2;
        imageViews[2] = image3;
        imageViews[3] = image4;

        wrongVoice = MediaPlayer.create(this, R.raw.alert_tone);

        // Home button to return back to the main activity
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        game(i);
        touchTheVoice = MediaPlayer.create(TouchTheLetterActivity.this, R.raw.touch_the);
        touchTheVoice.start();
        touchTheVoice.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                letterVoice = MediaPlayer.create(TouchTheLetterActivity.this, letters[i].getLetterSound());
                letterVoice.start();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        letterVoice.release();
        i++;
    }

    @Override
    public void onBackPressed() {
        dialog();
    }

    public void dialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(TouchTheLetterActivity.this);
        dialog.setMessage("Are You Sure, all the progress will be lost?");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                touchTheVoice.release();
                wrongVoice.release();
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

    public void game(final int i) {

        questionLetterImg.setImageResource(letters[i].getLetterImg());

        int[] randomIndices = new int[3];
        Log.v("IValue", String.valueOf(i));
        if (i == 0 || i == 1) {
            for (int j = 0; j < 3; j++) {
                randomIndices[j] = randInt(i + 1, letters.length);
            }
        } else if (i == letters.length-1) {
            for (int j = 0; j < 3; j++) {
                randomIndices[j] = randInt(0, i);
            }
        } else {
            randomIndices[0] = randInt(0, i - 1);
            randomIndices[1] = randInt(i + 1, letters.length);
            randomIndices[2] = randInt(0, (randomIndices[0] + randomIndices[1]) / 2);

            if(randomIndices[2]==i)
            {
                randomIndices[2]=randInt(i+1, letters.length);
            }

        }

        for (int k = 0; k < randomIndices.length-1; k++) {
            for (int j = k + 1; j < randomIndices.length; j++) {
                if (randomIndices[k] == randomIndices[j]) {
                    Log.v("DUPLICATED", "" + randomIndices[k]);

                    if (randomIndices[j] == letters.length-1)
                        randomIndices[j] = randInt(0, letters.length - 1);
                    else
                        randomIndices[j] = randInt(randomIndices[j] + j, letters.length);
                }
            }
        }


        int[] tempLetterImages = new int[3];
        for (int j = 0; j < 3; j++) {
            tempLetterImages[j] = letters[randomIndices[j]].getLetterImg();
        }

        // we will shuffle the tempLetterImages array who has 4 letters Imgs we have saved them
        Collections.shuffle(Arrays.asList(imageViews));



        for (int j = 0; j < imageViews.length; j++) {
            if (j != imageViews.length - 1) {
                imageViews[j].setImageResource(tempLetterImages[j]);
                imageViews[j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        wrongVoice.start();
                    }
                });
            } else {
                imageViews[j].setImageResource(letters[i].getLetterImg());
                imageViews[j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(TouchTheLetterActivity.this, ResultActivity.class);
                        intent.putExtra("AnimalImg", letters[i].getAnimalImg());
                        intent.putExtra("WordImg", letters[i].getWordImg());
                        intent.putExtra("ArabicReading", letters[i].getArabicReading());
                        intent.putExtra("EnglishMeaning", letters[i].getEnglishTranslation());
                        intent.putExtra("letterVoice", letters[i].getLetterSound());
                        intent.putExtra("WordVoice", letters[i].getWordSound());

                        startActivity(intent);
                    }
                });

            }
        }
    }

    public int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min) + min;
    }

}
