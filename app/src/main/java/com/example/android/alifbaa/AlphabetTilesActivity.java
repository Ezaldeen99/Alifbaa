package com.example.android.alifbaa;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by brayan pc on 12/4/2017.
 */

public class AlphabetTilesActivity extends AppCompatActivity {
    private static final CharacterIterator ABC =
            new StringCharacterIterator("abcdefghijklmnopqrstuvwxyz");
    List<Letter> letters;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet_tiles);

         letters =new ArrayList<>();

        int i = 0;
        for (char c = ABC.first();
             c != CharacterIterator.DONE;
             c = ABC.next(), i++) {



            int id = this.getResources().getIdentifier("letter_" + c,"drawable", this.getPackageName());
            letters.add(new Letter(i,id));

        }
        letters.add(new Letter(26,R.drawable.letter_z2));
        letters.add(new Letter(27,R.drawable.letter_z3));
        letters.add(new Letter(28,R.drawable.letter_z4));
        letters.add(new Letter(29,R.drawable.letter_z5));
        GridView gridView =(GridView) findViewById(R.id.drag_and_drop);
        alphabetTilesAdapter alphabetTilesAdapter=new alphabetTilesAdapter(this,R.layout.letter_item,letters);

        gridView.setAdapter(alphabetTilesAdapter);
    }
}
