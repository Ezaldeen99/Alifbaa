package com.example.android.alifbaa;


import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;


public class FlashCardsActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {
    private  boolean isShowingBackLayout = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.flash, new FrontLayoutFragment())
                    .commit();
        } else {
            isShowingBackLayout = (getFragmentManager().getBackStackEntryCount() > 0);
        }
        getFragmentManager().addOnBackStackChangedListener(this);
        View v = findViewById(R.layout.fragment_front_layout);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             flipCard();
            }
        });
    }

    public void flipCard() {
        Log.e(" ghgh","ghghgh");
        if (isShowingBackLayout) {
            getFragmentManager().popBackStack();
            return;
        }
        isShowingBackLayout = true;

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(
                        R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in, R.animator.flip_pic_out)
                .replace(R.id.flash, new BackLayoutFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackStackChanged() {
        isShowingBackLayout = (getFragmentManager().getBackStackEntryCount() > 0);
    }
}