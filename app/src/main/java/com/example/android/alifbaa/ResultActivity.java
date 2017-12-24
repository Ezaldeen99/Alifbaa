package com.example.android.alifbaa;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
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

        letterNameText =(TextView)findViewById(R.id.letter_sound_text);
        animalInEnglishText =(TextView)findViewById(R.id.animal_in_english);

        animalImg=(ImageView) findViewById(R.id.letter_animal_img);
        wordImg=(ImageView) findViewById(R.id.letter_animal_spelling_img);

        tickButton=(ImageView)findViewById(R.id.tick_button);
        tickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        String arabicReading= getIntent().getStringExtra("ArabicReading");
        String englishMeaning= getIntent().getStringExtra("EnglishMeaning");
        int animalImgResource= getIntent().getIntExtra("AnimalImg",R.drawable.ic_sun);
        int wordImgResource= getIntent().getIntExtra("WordImg",R.drawable.ic_sun);
        int letterVoiceResource= getIntent().getIntExtra("letterVoice",R.raw.keep_trying);
        int wordVoiceResource= getIntent().getIntExtra("WordVoice",R.raw.keep_trying);

        letterVoice=MediaPlayer.create(this,letterVoiceResource);
        wordVoice =MediaPlayer.create(this,wordVoiceResource);

        letterNameText.setText(arabicReading);
        animalInEnglishText.setText(englishMeaning);
        animalImg.setImageResource(animalImgResource);
        wordImg.setImageResource(wordImgResource);
    }

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        letterVoice.release();
        wordVoice.release();
    }
}
