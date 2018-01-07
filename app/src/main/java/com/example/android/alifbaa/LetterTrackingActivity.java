package com.example.android.alifbaa;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class LetterTrackingActivity extends AppCompatActivity {

    public static Viewbitmap viewbitmap = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter_tracking);

        final PaintView paintView;

        Button earser;
        earser = (Button) findViewById(R.id.erase);

        Button add;
        add = (Button) findViewById(R.id.add);

        ImageView r = (ImageView) findViewById(R.id.letter_tracing);
        Bitmap bmp = loadBitmapFromView(r);
        //convert the image view to a bitmap

        if (bmp == null) {
            Log.e("bitmap", "is null");
        }

        viewbitmap = new Viewbitmap();
        viewbitmap.setMbitmap(bmp);
//set the bitmap to access it in paintview
        paintView = (PaintView) findViewById(R.id.paintView);

        final DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        paintView.init(metrics);

        earser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.clear(metrics);

            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.create(metrics);

            }
        });


    }

    //this code will convert a view to bitmap
    public Bitmap loadBitmapFromView(View v) {
        final DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        Bitmap b = Bitmap.createBitmap(metrics.widthPixels, metrics.heightPixels, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.layout(0, 0, metrics.widthPixels, metrics.heightPixels);
        v.draw(c);
        if (b == null)
            return null;
        else
            return b;
    }
}
