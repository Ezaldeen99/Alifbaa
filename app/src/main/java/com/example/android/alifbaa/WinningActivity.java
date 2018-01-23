package com.example.android.alifbaa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinningActivity extends AppCompatActivity {

    Button homeButton;
    TextView scoreTextView;
    TextView bestScoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning);

        homeButton=findViewById(R.id.home_button);
        scoreTextView=findViewById(R.id.score);
        bestScoreTextView=findViewById(R.id.best_score);

        String score=getIntent().getStringExtra("SCORE");
        if(score !=null)
        {
            scoreTextView.setText(score);
            bestScoreTextView.setText("BestScore:"+score);
        }

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
