package com.example.android.alifbaa;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultActivity extends AppCompatActivity {

    ImageView tickButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_layout);

        tickButton=(ImageView)findViewById(R.id.tick_button);
        tickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
