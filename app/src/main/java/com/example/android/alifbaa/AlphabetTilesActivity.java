package com.example.android.alifbaa;

import android.content.ClipData;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayout;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

import java.util.Random;

/**
 * Created by brayan pc on 12/4/2017.
 */

public class AlphabetTilesActivity extends AppCompatActivity {
    private static final int NBR_ITEMS = 30;
    private GridLayout mGrid;
    int viewIndex = 0;
    int counter = 0;
    private int[] letters = {R.drawable.letter_a, R.drawable.letter_b, R.drawable.letter_c, R.drawable.letter_d, R.drawable.letter_e, R.drawable.letter_f,
            R.drawable.letter_g, R.drawable.letter_h, R.drawable.letter_i, R.drawable.letter_j, R.drawable.letter_k, R.drawable.letter_l
            , R.drawable.letter_m, R.drawable.letter_n, R.drawable.letter_o, R.drawable.letter_p, R.drawable.letter_q, R.drawable.letter_r
            , R.drawable.letter_s, R.drawable.letter_t, R.drawable.letter_u, R.drawable.letter_v, R.drawable.letter_w, R.drawable.letter_x
            , R.drawable.letter_y, R.drawable.letter_z, R.drawable.letter_z2, R.drawable.letter_z3, R.drawable.letter_z4, R.drawable.letter_z5};
    private int[] shuffledLetters = {R.drawable.letter_a, R.drawable.letter_b, R.drawable.letter_c, R.drawable.letter_d, R.drawable.letter_e, R.drawable.letter_f,
            R.drawable.letter_g, R.drawable.letter_h, R.drawable.letter_i, R.drawable.letter_j, R.drawable.letter_k, R.drawable.letter_l
            , R.drawable.letter_m, R.drawable.letter_n, R.drawable.letter_o, R.drawable.letter_p, R.drawable.letter_q, R.drawable.letter_r
            , R.drawable.letter_s, R.drawable.letter_t, R.drawable.letter_u, R.drawable.letter_v, R.drawable.letter_w, R.drawable.letter_x
            , R.drawable.letter_y, R.drawable.letter_z, R.drawable.letter_z2, R.drawable.letter_z3, R.drawable.letter_z4, R.drawable.letter_z5};
    private Chronometer clock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet_tiles);
        mGrid = findViewById(R.id.grid);
        mGrid.setOnDragListener(new DragListener());
        Button homeButton = findViewById(R.id.home_button);
        clock = findViewById(R.id.clock);
        clock.setFormat("Timer:%s");
        clock.start();
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog();
            }
        });
        Random r = new Random();
        for (int item = NBR_ITEMS - 1; item > 0; item--) {
            int k = r.nextInt(item);
            int e = shuffledLetters[item];
            shuffledLetters[item] = shuffledLetters[k];
            shuffledLetters[k] = e;
        }
        final LayoutInflater inflater = LayoutInflater.from(this);
        for (int i = 0; i < NBR_ITEMS; i++) {
            final View itemView = inflater.inflate(R.layout.grid_item, mGrid, false);
            final ImageView image = itemView.findViewById(R.id.text);
            image.setImageResource(shuffledLetters[i]);
            itemView.setId(shuffledLetters[i]);
            itemView.setOnLongClickListener(new LongPressListener());
            mGrid.addView(itemView);
        }
    }

    static class LongPressListener implements View.OnLongClickListener {
        @Override
        public boolean onLongClick(View view) {
            final ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data, shadowBuilder, view, 0);
            view.setVisibility(View.INVISIBLE);
            return true;
        }
    }

    class DragListener implements View.OnDragListener {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            final View view = (View) event.getLocalState();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_LOCATION:
                    // do nothing if hovering above own position
                    if (view == v) return true;
                    // get the new list index
                    final int index = calculateNewIndex(event.getX(), event.getY());
                    // remove the view from the old position
                    viewIndex = index;
                    mGrid.removeView(view);
                    // and push to the new
                    mGrid.addView(view, index);
                    break;
                case DragEvent.ACTION_DROP:
                    counter = 0;
                    for (int j = 0; j < NBR_ITEMS; j++) {
                        View ourView = mGrid.getChildAt(j);
                        if (ourView.getId() == letters[j]) {
                            counter++;
                            ourView.setBackgroundColor(Color.GREEN);
                        } else {
                            ourView.setBackgroundColor(Color.WHITE);
                        }
                    }
                    if (counter == NBR_ITEMS) {
                        String chronoText = clock.getText().toString();
                        String array[] = chronoText.split(":");
                       int stoppedMilliseconds = Integer.parseInt(array[1]) * 60 * 1000
                               + Integer.parseInt(array[2]) * 1000;
                       int estmateTime = 3660000;

                        clock.stop();
                        //TODO start intent here to view the result and save the result if it is the best score.
                        //Log.e("finish", "" + (estmateTime-stoppedMilliseconds));
                    }
                    view.setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    if (!event.getResult()) {
                        view.setVisibility(View.VISIBLE);
                    }
                    break;
            }
            return true;
        }
    }

    private int calculateNewIndex(float x, float y) {
        // calculate which column to move to
        final float cellWidth = mGrid.getWidth() / mGrid.getColumnCount();
        final int column = (int) (x / cellWidth);
        // calculate which row to move to
        final float cellHeight = mGrid.getHeight() / mGrid.getRowCount();
        final int row = (int) Math.floor(y / cellHeight);
        // the items in the GridLayout is organized as a wrapping list
        // and not as an actual grid, so this is how to get the new index
        int index = row * mGrid.getColumnCount() + column;
        if (index >= mGrid.getChildCount()) {
            index = mGrid.getChildCount() - 1;
        }

        return index;
    }

    @Override
    public void onBackPressed() {
        dialog();
    }

    public void dialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(AlphabetTilesActivity.this);
        dialog.setMessage("Are You Sure, all the progress will be lost?");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        dialog.create().show();
    }
}
