package com.example.android.alifbaa;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;


public class FlashCardsActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip);
        Button home = findViewById(R.id.home_button);
        Button next = findViewById(R.id.btn_next);
        Button prev = findViewById(R.id.btn_prev);
        getFragmentManager()
                .beginTransaction()
                .add(R.id.image_flip, new FrontLayoutFragment())
                .commit();
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public void flipCard(boolean showingBackLayout) {
        if (showingBackLayout) {
            getFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                            R.animator.card_flip_left_in, R.animator.flip_pic_out)
                    .replace(R.id.image_flip, new FrontLayoutFragment())
                    .addToBackStack(null)
                    .commit();
        } else {
            getFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                            R.animator.card_flip_left_in, R.animator.flip_pic_out)
                    .replace(R.id.image_flip, new BackLayoutFragment())
                    .addToBackStack(null)
                    .commit();
        }
    }
}