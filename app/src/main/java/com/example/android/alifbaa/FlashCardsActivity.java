package com.example.android.alifbaa;


import android.app.Fragment;
import android.app.FragmentManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import java.util.Random;


public class FlashCardsActivity extends FragmentActivity {

    private int[] AnimalsSounds = {R.raw.obj_1, R.raw.obj_2, R.raw.obj_3, R.raw.obj_4, R.raw.obj_5, R.raw.obj_6, R.raw.obj_7, R.raw.obj_8,
            R.raw.obj_9, R.raw.obj_10, R.raw.obj_11, R.raw.obj_12, R.raw.obj_13, R.raw.obj_14, R.raw.obj_15, R.raw.obj_16, R.raw.obj_17,
            R.raw.obj_18, R.raw.obj_19, R.raw.obj_20, R.raw.obj_21, R.raw.obj_22, R.raw.obj_23, R.raw.obj_24, R.raw.obj_25, R.raw.obj_26,
            R.raw.obj_27, R.raw.obj_28, R.raw.obj_29, R.raw.obj_30};

    private static final int NBR_ITEMS = 30;

    private int[] letterSounds = {R.raw.letter_1, R.raw.letter_2, R.raw.letter_3, R.raw.letter_4, R.raw.letter_5, R.raw.letter_6, R.raw.letter_7, R.raw.letter_8,
            R.raw.letter_9, R.raw.letter_10, R.raw.letter_11, R.raw.letter_12, R.raw.letter_13, R.raw.letter_14, R.raw.letter_15, R.raw.letter_16, R.raw.letter_17,
            R.raw.letter_18, R.raw.letter_19, R.raw.letter_20, R.raw.letter_21, R.raw.letter_22, R.raw.letter_23, R.raw.letter_24, R.raw.letter_25, R.raw.letter_26,
            R.raw.letter_27, R.raw.letter_28, R.raw.letter_29, R.raw.letter_30};

    private int[] letters = {R.drawable.letter_a, R.drawable.letter_b, R.drawable.letter_c, R.drawable.letter_d, R.drawable.letter_e, R.drawable.letter_f,
            R.drawable.letter_g, R.drawable.letter_h, R.drawable.letter_i, R.drawable.letter_j, R.drawable.letter_k, R.drawable.letter_l
            , R.drawable.letter_m, R.drawable.letter_n, R.drawable.letter_o, R.drawable.letter_p, R.drawable.letter_q, R.drawable.letter_r
            , R.drawable.letter_s, R.drawable.letter_t, R.drawable.letter_u, R.drawable.letter_v, R.drawable.letter_w, R.drawable.letter_x
            , R.drawable.letter_y, R.drawable.letter_z, R.drawable.letter_z2, R.drawable.letter_z3, R.drawable.letter_z4, R.drawable.letter_z5};

    private int[] animals = {R.drawable.animal_a, R.drawable.animal_b, R.drawable.animal_c, R.drawable.animal_d, R.drawable.animal_e, R.drawable.animal_f
            , R.drawable.animal_g, R.drawable.animal_h, R.drawable.animal_i, R.drawable.animal_j, R.drawable.animal_k, R.drawable.animal_l
            , R.drawable.animal_m, R.drawable.animal_n, R.drawable.animal_o, R.drawable.animal_p, R.drawable.animal_q, R.drawable.animal_r
            , R.drawable.animal_s, R.drawable.animal_t, R.drawable.animal_u, R.drawable.animal_v, R.drawable.animal_w, R.drawable.animal_x
            , R.drawable.animal_y, R.drawable.animal_z, R.drawable.animal_z2, R.drawable.animal_z3, R.drawable.animal_z4, R.drawable.animal_z5};

    private int[] animalsSpelling = {R.drawable.spelling_a, R.drawable.spelling_b, R.drawable.spelling_c, R.drawable.spelling_d, R.drawable.spelling_e, R.drawable.spelling_f
            , R.drawable.spelling_c, R.drawable.spelling_h, R.drawable.spelling_i, R.drawable.spelling_j, R.drawable.spelling_k, R.drawable.spelling_l
            , R.drawable.spelling_m, R.drawable.spelling_n, R.drawable.spelling_o, R.drawable.spelling_p, R.drawable.spelling_q, R.drawable.spelling_r
            , R.drawable.spelling_s, R.drawable.spelling_t, R.drawable.spelling_u, R.drawable.spelling_v, R.drawable.spelling_w, R.drawable.spelling_x
            , R.drawable.spelling_y, R.drawable.spelling_z, R.drawable.spelling_z2, R.drawable.spelling_z3, R.drawable.spelling_z4, R.drawable.spelling_z5};

    private int[] arabicLetterSpelling = {R.string.alif, R.string.baa, R.string.taa, R.string.thaa, R.string.jeem,
            R.string.haa, R.string.khaa, R.string.daal, R.string.dhall, R.string.raa, R.string.zaa, R.string.seen,
            R.string.sheen, R.string.saad, R.string.dhaad, R.string.taa, R.string.zaa, R.string.ayn, R.string.ghayan,
            R.string.faa, R.string.qaaf, R.string.kaaf, R.string.laam, R.string.meem, R.string.noon, R.string.waaw,
            R.string.haa, R.string.laam_alif, R.string.hamza, R.string.yaa};

    private int[] englishWords = {R.string.rabbit, R.string.duck, R.string.crocodile, R.string.fox, R.string.camel,
            R.string.horse, R.string.sheep, R.string.bear, R.string.housefly, R.string.raccoon, R.string.giraffe,
            R.string.fish, R.string.lion_cub, R.string.hawk, R.string.frog, R.string.peacock, R.string.antelope,
            R.string.spider, R.string.crow, R.string.elephant, R.string.cat, R.string.dog, R.string.strok, R.string.goat,
            R.string.tiger, R.string.rhino, R.string.hoopoe, R.string.llama, R.string.lion, R.string.dragonfly};

    private int[] arabicWords = {R.string.arnab, R.string.batta, R.string.timsah, R.string.thalab, R.string.jamal,
            R.string.hisan, R.string.kharoof, R.string.dob, R.string.thababah, R.string.racoown, R.string.zarraffah,
            R.string.samakah, R.string.shibl, R.string.saqar, R.string.dhafdaah, R.string.tawoos, R.string.dhaby,
            R.string.anacaboot, R.string.goraab, R.string.feel, R.string.qitta, R.string.kalb, R.string.laq_laq,
            R.string.maiz, R.string.namir, R.string.waheed, R.string.hoodhood, R.string.laamaa, R.string.asad, R.string.yassob};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip);
        Button home = findViewById(R.id.home_button);
        Button next = findViewById(R.id.btn_next);
        Button prev = findViewById(R.id.btn_prev);

        // Checking the Random order Activation
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String randomOrder = preferences.getString("RANDOM", "OFF");
        if (randomOrder.equals("ON")) {
            Random r = new Random();
            for (int item = NBR_ITEMS - 1; item > 0; item--) {
                int k = r.nextInt(item);
                int e = AnimalsSounds[item];
                AnimalsSounds[item] = AnimalsSounds[k];
                AnimalsSounds[k] = e;
                e = letterSounds[item];
                letterSounds[item] = letterSounds[k];
                letterSounds[k] = e;
                e = letters[item];
                letters[item] = letters[k];
                letters[k] = e;
                e = animals[item];
                animals[item] = animals[k];
                animals[k] = e;
                e = animalsSpelling[item];
                animalsSpelling[item] = animalsSpelling[k];
                animalsSpelling[k] = e;
                e = arabicLetterSpelling[item];
                arabicLetterSpelling[item] = arabicLetterSpelling[k];
                arabicLetterSpelling[k] = e;
                e = englishWords[item];
                englishWords[item] = englishWords[k];
                englishWords[k] = e;
                e = arabicWords[item];
                arabicWords[item] = arabicWords[k];
                arabicWords[k] = e;
            }
        }
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        final ViewPager vpPager = findViewById(R.id.viewpager);
        CardPagerAdapter adapter = new CardPagerAdapter(getFragmentManager());
        vpPager.setAdapter(adapter);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vpPager.setCurrentItem(vpPager.getCurrentItem() + 1, true);


            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vpPager.setCurrentItem(vpPager.getCurrentItem() - 1, true);

            }
        });
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
            return new CardContainerFragment().newInstance(i, AnimalsSounds, letterSounds, letters, animals, animalsSpelling
                    , arabicLetterSpelling, englishWords, arabicWords);
        }

        @Override
        public int getCount() {
            return 30;
        }
    }
}
