package com.example.android.alifbaa;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;


public class FlashCardsActivity extends FragmentActivity {
    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip);
        Button home = findViewById(R.id.home_button);
        Button next = findViewById(R.id.btn_next);
        Button prev = findViewById(R.id.btn_prev);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ViewPager vpPager = findViewById(R.id.viewpager);
        CardPagerAdapter adapter = new CardPagerAdapter(getFragmentManager());
        vpPager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
    public class CardPagerAdapter extends android.support.v13.app.FragmentPagerAdapter {

        public CardPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return new CardContainerFragment().newInstance(i);
        }

        @Override
        public int getCount() {
            return 30;
        }
    }
}