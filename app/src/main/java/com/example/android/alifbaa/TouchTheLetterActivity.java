package com.example.android.alifbaa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class TouchTheLetterActivity extends AppCompatActivity {
    Button homeButton;

    TextView findTheLetterText;
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
    Letter[] letters = {
            new Letter(1, R.drawable.letter_a, R.drawable.animal_a, R.drawable.spelling_a,
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
                    R.string.khaa, R.string.sheep, R.raw.letter_7, R.raw.obj_7),
            new Letter(8, R.drawable.letter_h, R.drawable.animal_h, R.drawable.spelling_h,
                    R.string.daal, R.string.bear, R.raw.letter_8, R.raw.obj_8),
            new Letter(9, R.drawable.letter_i, R.drawable.animal_i, R.drawable.spelling_i,
                    R.string.dhaad, R.string.housefly, R.raw.letter_9, R.raw.obj_9),
            new Letter(10, R.drawable.letter_j, R.drawable.animal_j, R.drawable.spelling_j,
                    R.string.raa, R.string.raccoon, R.raw.letter_10, R.raw.obj_10),
            new Letter(11, R.drawable.letter_k, R.drawable.animal_k, R.drawable.spelling_k,
                    R.string.zaa, R.string.giraffe, R.raw.letter_11, R.raw.obj_11),
            new Letter(12, R.drawable.letter_l, R.drawable.animal_l, R.drawable.spelling_l,
                    R.string.seen, R.string.fish, R.raw.letter_12, R.raw.obj_12),
            new Letter(13, R.drawable.letter_m, R.drawable.animal_m, R.drawable.spelling_m,
                    R.string.sheen, R.string.lion_cub, R.raw.letter_13, R.raw.obj_13),
            new Letter(14, R.drawable.letter_n, R.drawable.animal_n, R.drawable.spelling_n,
                    R.string.saad, R.string.hawk, R.raw.letter_14, R.raw.obj_14),
            new Letter(15, R.drawable.letter_o, R.drawable.animal_o, R.drawable.spelling_o,
                    R.string.dhaad, R.string.frog, R.raw.letter_15, R.raw.obj_15),
            new Letter(16, R.drawable.letter_p, R.drawable.animal_p, R.drawable.spelling_p,
                    R.string.taa, R.string.peacock, R.raw.letter_16, R.raw.obj_16),
            new Letter(17, R.drawable.letter_q, R.drawable.animal_q, R.drawable.spelling_q,
                    R.string.zaa, R.string.antelope, R.raw.letter_17, R.raw.obj_17),
            new Letter(18, R.drawable.letter_r, R.drawable.animal_r, R.drawable.spelling_r,
                    R.string.ayn, R.string.spider, R.raw.letter_18, R.raw.obj_18),
            new Letter(19, R.drawable.letter_s, R.drawable.animal_s, R.drawable.spelling_s,
                    R.string.ghayan, R.string.crow, R.raw.letter_19, R.raw.obj_19),
            new Letter(20, R.drawable.letter_t, R.drawable.animal_t, R.drawable.spelling_t,
                    R.string.faa, R.string.elephant, R.raw.letter_20, R.raw.obj_20),
            new Letter(21, R.drawable.letter_u, R.drawable.animal_u, R.drawable.spelling_u,
                    R.string.qaaf, R.string.cat, R.raw.letter_21, R.raw.obj_21),
            new Letter(22, R.drawable.letter_v, R.drawable.animal_v, R.drawable.spelling_v,
                    R.string.kaaf, R.string.dog, R.raw.letter_22, R.raw.obj_22),
            new Letter(23, R.drawable.letter_w, R.drawable.animal_w, R.drawable.spelling_w,
                    R.string.laam, R.string.strok, R.raw.letter_23, R.raw.obj_23),
            new Letter(24, R.drawable.letter_x, R.drawable.animal_x, R.drawable.spelling_x,
                    R.string.meem, R.string.goat, R.raw.letter_24, R.raw.obj_24),
            new Letter(25, R.drawable.letter_y, R.drawable.animal_y, R.drawable.spelling_y,
                    R.string.noon, R.string.tiger, R.raw.letter_25, R.raw.obj_25),
            new Letter(26, R.drawable.letter_z, R.drawable.animal_z, R.drawable.spelling_z,
                    R.string.waaw, R.string.rhino, R.raw.letter_26, R.raw.obj_26),
            new Letter(27, R.drawable.letter_z2, R.drawable.animal_z2, R.drawable.spelling_z2,
                    R.string.haa, R.string.hoopoe, R.raw.letter_27, R.raw.obj_27),
            new Letter(28, R.drawable.letter_z3, R.drawable.animal_z3, R.drawable.spelling_z3,
                    R.string.laam_alif, R.string.llama, R.raw.letter_28, R.raw.obj_28),
            new Letter(29, R.drawable.letter_z4, R.drawable.animal_z4, R.drawable.spelling_z4,
                    R.string.hamza, R.string.lion, R.raw.letter_29, R.raw.obj_29),
            new Letter(30, R.drawable.letter_z5, R.drawable.animal_z5, R.drawable.spelling_z5,
                    R.string.yaa, R.string.dragonfly, R.raw.letter_30, R.raw.obj_30)
    };

    // Load the animation like this
    Animation animSlideRight;
    Animation animSlideLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_the_letter);

        homeButton = findViewById(R.id.home_button);
        findTheLetterText = findViewById(R.id.find_the_letter_text);
        questionLetterImg = findViewById(R.id.question_letter_img);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);

        // initialization of the sliding animation
        animSlideRight = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_right);
        animSlideLeft = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_left);

        // adding the images views to an array
        imageViews[0] = image1;
        imageViews[1] = image2;
        imageViews[2] = image3;
        imageViews[3] = image4;

        // Check the SharedPreferences for Enabling Random Order and Display Hints Options from settings activity.
        // For Displaying the hints .
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String displayHints = preferences.getString("HINTS", "ON");

        if (!displayHints.equals("ON")) {
            findTheLetterText.setVisibility(View.INVISIBLE);
            questionLetterImg.setVisibility(View.INVISIBLE);
        } else {
            findTheLetterText.setVisibility(View.VISIBLE);
            questionLetterImg.setVisibility(View.VISIBLE);
        }

        // for random order Activation, it is ON so the letters inside array will be replaced.
        String randomOrder = preferences.getString("RANDOM", "OFF");
        if (randomOrder.equals("ON")) {
            for (int item = letters.length - 1; item > 0; item--) {
                int randomIndex = randInt(0, item);
                Letter temp = letters[item];
                letters[item] = letters[randomIndex];
                letters[randomIndex] = temp;
            }
        }

        /// initialize wrong voice
        wrongVoice = MediaPlayer.create(this, R.raw.alert_tone);

        // Home button to return back to the main activity
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog();
            }
        });
    }

    // when the activity starts, it prepares the layout with randomly four-selected objects
    // from the Letters array and add the letters images to the screen.
    //Also assign the animation to the four options image views(letters images).as well as,
    // initializing the touch the sound and letter sound.
    @Override
    protected void onStart() {
        super.onStart();
        if (i == letters.length) {
            gameDone();
        } else {
            game(i);

            // Start the animation like this
            image1.startAnimation(animSlideRight);
            image3.startAnimation(animSlideRight);
            image2.startAnimation(animSlideLeft);
            image4.startAnimation(animSlideLeft);
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
    }

    // when the activity stops it release the current letter voice and increment the i.
    @Override
    protected void onStop() {
        super.onStop();
        letterVoice.release();
        i++;
    }

    // in case the user click the bac button, it will ask if he want to lose his progress or not.
    @Override
    public void onBackPressed() {
        dialog();
    }

    // the dialog function is responsible for displaying alert dialog to notify the user that he will lose his progress
    // if he exit the game and give him two options(Yes,No).
    public void dialog() {
        CustomDialog cdd = new CustomDialog(TouchTheLetterActivity.this);
        cdd.show();
    }

    // the game function is responsible for developing the random images for display them on the game screen and ,
    // ensure that the user chose the right letter-image for the right image and in case the user chose the correct answer
    // new activity will be opened with the rest of the Letter-object values.
    // the function takes the recent i as parameter,according to i it develop random numbers from (0-30) and save them
    // to randomIndices array which will be the indexes for randomly-selected-Letter-objects from Letters array.
    // we check for any duplication in the randomIndices array.after that, we generate another array that has the
    // imagesResourceId(tempLetterImage) from the Letters array. we shuffle the imageViews array (that has the imagesViews)
    // and we assign each imageView to the one of imageResourceId(tempLetterImage).
    public void game(final int i) {

        questionLetterImg.setImageResource(letters[i].getLetterImg());

        int[] randomIndices = new int[3];
        Log.v("IValue", String.valueOf(i));
        if (i == 0 || i == 1) {
            for (int j = 0; j < 3; j++) {
                randomIndices[j] = randInt(i + 1, letters.length);
            }
        } else if (i == letters.length - 1) {
            for (int j = 0; j < 3; j++) {
                randomIndices[j] = randInt(0, i);
            }
        } else {
            randomIndices[0] = randInt(0, i - 1);
            randomIndices[1] = randInt(i + 1, letters.length);
            randomIndices[2] = randInt(0, (randomIndices[0] + randomIndices[1]) / 2);

            if (randomIndices[2] == i) {
                randomIndices[2] = randInt(i + 1, letters.length);
            }

        }
        // for checking the randomIndices for any duplication, in case the is duplicated numbers it will be regenerating
        // EX: 4,5,4
        // Result: 4,5,8
        randomIndices = checkForDuplication(randomIndices);


        int[] tempLetterImages = new int[3];
        for (int j = 0; j < 3; j++) {
            tempLetterImages[j] = letters[randomIndices[j]].getLetterImg();
        }

        // we will shuffle the imageViews array who has 4 ImageViews we have saved them
        Collections.shuffle(Arrays.asList(imageViews));

        //  we assign each imageView to the one of imageResourceId(tempLetterImage) with assigning we add the wrong voice
        // to the wrong option (OnClickListener) and the last imageViews element will be the correct answer when the user click
        // new activity will be opened with the rest of the object fields.
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

    private int[] checkForDuplication(int[] randomIndices) {
        for (int k = 0; k < randomIndices.length - 1; k++) {
            for (int j = k + 1; j < randomIndices.length; j++) {
                if (randomIndices[k] == randomIndices[j]) {
                    Log.v("DUPLICATED", "" + randomIndices[k]);

                    if (randomIndices[j] == letters.length - 1)
                        randomIndices[j] = randInt(0, letters.length - 1);
                    else
                        randomIndices[j] = randInt(randomIndices[j] + j, letters.length);
                }
            }
        }
        return randomIndices;
    }

    private void gameDone() {
        finish();
        Intent intent = new Intent(TouchTheLetterActivity.this, WinningActivity.class);
        startActivity(intent);
    }

    // randInt is responsible for generating thr random number between two numbers.
    public int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min) + min;
    }

}
