package com.example.android.alifbaa;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
import android.widget.ListAdapter;

/**
 * Created by Sulaiman on 22/12/2017.
 */

// alphabet
public class AlphabetGridView extends GridView {
    public AlphabetGridView(Context context) {
        super(context);
        this.setNumColumns(5);
    }

    public AlphabetGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setNumColumns(5);
    }


     // Set adapter of AlphabetGridView.

    @Override
    public void setAdapter(ListAdapter adapter) {
        if (!(adapter instanceof alphabetTilesAdapter)) {
            throw new IllegalArgumentException("adapter must be an instance of DNDAdapter!");
        }
        super.setAdapter(adapter);
    }
}

