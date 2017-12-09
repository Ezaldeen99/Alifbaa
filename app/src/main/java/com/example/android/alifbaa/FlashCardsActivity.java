package com.example.android.alifbaa;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


public class FlashCardsActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip);
        getFragmentManager()
                .beginTransaction()
                .add(R.id.flash, new FrontLayoutFragment())
                .commit();
    }

    public void flipCard(boolean showingBackLayout) {
        if (showingBackLayout) {
            getFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                            R.animator.card_flip_left_in, R.animator.flip_pic_out)
                    .replace(R.id.flash, new FrontLayoutFragment())
                    .addToBackStack(null)
                    .commit();
        } else {
            getFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                            R.animator.card_flip_left_in, R.animator.flip_pic_out)
                    .replace(R.id.flash, new BackLayoutFragment())
                    .addToBackStack(null)
                    .commit();
        }
    }
}