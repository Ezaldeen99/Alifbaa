package com.example.android.alifbaa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class TouchTheLetterActivity extends AppCompatActivity {
    Button homeButton;
    ImageView image1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_the_letter);

        homeButton = findViewById(R.id.home_button);

        // Home button to return back to the main activity
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog();
            }
        });
    }

    @Override
    public void onBackPressed() {
        dialog();
    }

    public void dialog() {
        CustomDialog cdd=new CustomDialog(TouchTheLetterActivity.this);
        cdd.show();
    }
}
