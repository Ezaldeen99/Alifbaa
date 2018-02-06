package com.example.android.alifbaa;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class LetterTrackingActivity extends AppCompatActivity {
    static ImageView imageView;
    int lettersCounter = 1;
    Letter[] letters = {
            new Letter(1, R.drawable.letter_a),
            new Letter(2, R.drawable.letter_b),
            new Letter(3, R.drawable.letter_c),
            new Letter(4, R.drawable.letter_d),
            new Letter(5, R.drawable.letter_e),
            new Letter(6, R.drawable.letter_f),
            new Letter(7, R.drawable.letter_g),
            new Letter(8, R.drawable.letter_h),
            new Letter(9, R.drawable.letter_i),
            new Letter(10, R.drawable.letter_j),
            new Letter(11, R.drawable.letter_k),
            new Letter(12, R.drawable.letter_l),
            new Letter(13, R.drawable.letter_m),
            new Letter(14, R.drawable.letter_n),
            new Letter(15, R.drawable.letter_o),
            new Letter(16, R.drawable.letter_p),
            new Letter(17, R.drawable.letter_q),
            new Letter(18, R.drawable.letter_r),
            new Letter(19, R.drawable.letter_s),
            new Letter(20, R.drawable.letter_t),
            new Letter(21, R.drawable.letter_u),
            new Letter(22, R.drawable.letter_v),
            new Letter(23, R.drawable.letter_w),
            new Letter(24, R.drawable.letter_x),
            new Letter(25, R.drawable.letter_y),
            new Letter(26, R.drawable.letter_z),
            new Letter(27, R.drawable.letter_z2),
            new Letter(28, R.drawable.letter_z5)};

    public static Viewbitmap viewbitmap = null;
    PaintView paintView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter_tracking);
        imageView = findViewById(R.id.letter_tracing);


        Button earser;
        earser = (Button) findViewById(R.id.erase);
        Button home;
        home = (Button) findViewById(R.id.home_button);


//set the bitmap to access it in paintview
        paintView = (PaintView) findViewById(R.id.paintView);
        ImageView imageView = (ImageView) findViewById(R.id.letter_tracing);


        Bitmap bmp = convertViewToBitmap(imageView);
        //convert the image view to a bitmap


//set the bitmap in paint view
        viewbitmap = new Viewbitmap();
        viewbitmap.setMbitmap(bmp);


        final DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

//intialize the paintiew
        paintView.init(metrics);

//call clear when the earser pressed
        earser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.clear(metrics);

            }
        });
//        exit game when user press home
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog();
            }
        });


    }

    @Override
    protected void onRestart() {
//        on restart change the letter and its bitmap and set its value again
        super.onRestart();
        if (lettersCounter != letters.length) {
//            if the counter reaches the end of the arraylist the game ends
            imageView.setImageResource(letters[lettersCounter].getLetterImg());
            lettersCounter++;

            Bitmap bmp = convertViewToBitmap(imageView);
            //convert the image view to a bitmap

            viewbitmap = new Viewbitmap();
            viewbitmap.setMbitmap(bmp);

            final DisplayMetrics metrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metrics);

            paintView.clear(metrics);
            paintView.init(metrics);
        } else {
            gameDone();
        }

    }


//this code will convert a view to bitmap

    public final Bitmap convertViewToBitmap(View v) {
        final DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        Bitmap bitmap = Bitmap.createBitmap(metrics.widthPixels, metrics.heightPixels, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        v.layout(0, 0, metrics.widthPixels, metrics.heightPixels);
        v.draw(canvas);
        if (bitmap == null)
            return null;
        else
            return bitmap;
    }

    @Override
    public void onBackPressed() {
        final DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        paintView.clear(metrics);
        finish();
    }

    //this will be called when game finishes
    private void gameDone() {
        finish();
        Intent intent = new Intent(LetterTrackingActivity.this, WinningActivity.class);
        startActivity(intent);
    }

    public void dialog() {
        CustomDialog cdd = new CustomDialog(LetterTrackingActivity.this);
        cdd.show();
    }
}
