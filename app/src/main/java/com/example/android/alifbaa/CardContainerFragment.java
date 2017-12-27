package com.example.android.alifbaa;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CardContainerFragment extends android.app.Fragment {
    private int position;
    private boolean cardFlipped = false;

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

    private String[] arabicLetterSpelling = {"alif", "baa", "taa", "thaa", "jeem", "haa", "khaa", "daal", "dhall", "raa", "zaa",
            "seen", "sheen", "saad", "dhaad", "taa", "zaa", "ayn", "ghayan", "faa", "qaaf", "kaaf", "laam", "meem", "noon", "waaw",
            "haa", "laam alif", "hamza", "yaa"};

    public CardContainerFragment() {
        setHasOptionsMenu(true);
    }

    CardContainerFragment newInstance(int num) {
        CardContainerFragment f = new CardContainerFragment();
        Bundle args = new Bundle();
        args.putInt("image", num);
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        position = getArguments().getInt("image", 0);
        View rootView = inflater.inflate(R.layout.fragment_card_container, container, false);
        getChildFragmentManager()
                .beginTransaction()
                .add(R.id.container, new CardFrontFragment())
                .commit();

        return rootView;
    }

    public void flipCard() {
        android.app.Fragment newFragment;
        if (cardFlipped) {
            newFragment = new CardFrontFragment();
        } else {
            newFragment = new CardBackFragment();
        }

        getChildFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in, R.animator.card_flip_left_out)
                .replace(R.id.container, newFragment)
                .commit();

        cardFlipped = !cardFlipped;
    }

    @SuppressLint("ValidFragment")
    public class CardFrontFragment extends android.app.Fragment {

        public CardFrontFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_front_layout, container, false);
            ImageView imageView = rootView.findViewById(R.id.image_linear);
            imageView.setImageResource(letters[position]);
            TextView text = rootView.findViewById(R.id.arabic_spelling);
            text.setText(arabicLetterSpelling[position]);
            rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    flipCard();
                }
            });
            return rootView;
        }
    }

    @SuppressLint("ValidFragment")
    public class CardBackFragment extends android.app.Fragment {

        public CardBackFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_back_layout, container, false);
            ImageView animalView = rootView.findViewById(R.id.animal_img);
            ImageView speeling = rootView.findViewById(R.id.letter_animal_spelling_img);
            TextView animalArabic = rootView.findViewById(R.id.letter_sound_text);
            TextView animalEnglish = rootView.findViewById(R.id.animal_in_english);
            animalView.setImageResource(animals[position]);
            speeling.setImageResource(animalsSpelling[position]);
            rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    flipCard();
                }
            });
            return rootView;
        }
    }
}