package com.example.android.alifbaa;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// This activity is shown at the end of any game, which showes the trophy image , user score in that game
// and buttons to share his/her score on social media and to save it in the leader board.
// Note: Social Media Integration (Facebook and Twitter) and Saved to leader board are not active.
public class WinningActivity extends AppCompatActivity {


    Button homeButton;
    TextView scoreTextView;
    TextView bestScoreTextView;
    TextView yourScoreWasText;
    MediaPlayer congratsVoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning);

        homeButton = findViewById(R.id.home_button);
        scoreTextView = findViewById(R.id.score);
        bestScoreTextView = findViewById(R.id.best_score);
        yourScoreWasText = findViewById(R.id.your_score_was_text);
        congratsVoice = MediaPlayer.create(this, R.raw.marsh_youve_done_it);

        //Check the SharedPreferences for Enable Scoring Option from settings activity.
        // if it is ON so the score will be shown on the activity otherwise no score will be displayed.
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String enableScoring = preferences.getString("SCORING", "ON");

        if (enableScoring.equals("ON")) {
            String score = getIntent().getStringExtra("SCORE");
            yourScoreWasText.setVisibility(View.VISIBLE);
            scoreTextView.setVisibility(View.VISIBLE);
            bestScoreTextView.setVisibility(View.VISIBLE);
            if (score != null) {
                scoreTextView.setText(score);
                bestScoreTextView.setText(getString(R.string.best_score) + score);
            }
        } else {
            yourScoreWasText.setVisibility(View.GONE);
            scoreTextView.setVisibility(View.GONE);
            bestScoreTextView.setVisibility(View.GONE);
        }

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    // OnStart Activity plays congrats sound.
    @Override
    protected void onStart() {
        super.onStart();
        congratsVoice.start();
    }

    // OnDestroy Activity releases congrats sound.
    @Override
    protected void onDestroy() {
        super.onDestroy();
        congratsVoice.release();
    }
}
