package com.example.android.alifbaa;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

// This activity will work with Touch The Letter game, When the user click the right letter this
// activity with show off and display the object image with its spelling in both Arabic and English
// and the letter and object spelling sound as well.
public class ResultActivity extends AppCompatActivity {

    TextView letterNameText;
    TextView animalInEnglishText;

    ImageView animalImg;
    ImageView wordImg;
    ImageView tickButton;

    MediaPlayer letterVoice;
    MediaPlayer wordVoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_layout);

        letterNameText = findViewById(R.id.letter_sound_text);
        animalInEnglishText = findViewById(R.id.animal_in_english);

        animalImg = findViewById(R.id.letter_animal_img);
        wordImg = findViewById(R.id.letter_animal_spelling_img);

        tickButton = findViewById(R.id.tick_button);
        tickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // the informatoin of hte letter will come with intent call.
        int arabicReading = getIntent().getIntExtra("ArabicReading", R.string.alif);
        int englishMeaning = getIntent().getIntExtra("EnglishMeaning", R.string.arnab);
        int animalImgResource = getIntent().getIntExtra("AnimalImg", R.drawable.ic_sun);
        int wordImgResource = getIntent().getIntExtra("WordImg", R.drawable.ic_sun);
        int letterVoiceResource = getIntent().getIntExtra("letterVoice", R.raw.keep_trying);
        int wordVoiceResource = getIntent().getIntExtra("WordVoice", R.raw.keep_trying);

        // arrange the sounds ,textViews and ImageViews with letter information.
        letterVoice = MediaPlayer.create(this, letterVoiceResource);
        wordVoice = MediaPlayer.create(this, wordVoiceResource);

        letterNameText.setText(arabicReading);
        animalInEnglishText.setText(englishMeaning);
        animalImg.setImageResource(animalImgResource);
        wordImg.setImageResource(wordImgResource);
    }

    // onStart of the activity the letter sound will start followed by object word sound.
    @Override
    protected void onStart() {
        super.onStart();
        letterVoice.start();
        letterVoice.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                wordVoice.start();
            }
        });
    }

    // onDestory the activity the letter sound and object word sound will be released.
    @Override
    protected void onDestroy() {
        super.onDestroy();
        letterVoice.release();
        wordVoice.release();
    }
}
