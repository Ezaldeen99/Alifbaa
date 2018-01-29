package com.example.android.alifbaa;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class BlackBoardActivity extends Activity {
   PaintViewResult paintView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_board);


        paintView = (PaintViewResult) findViewById(R.id.p);
        Button tick = (Button) findViewById(R.id.tick);

        final DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);


        paintView.init(metrics);
        ImageView imageView = findViewById(R.id.im);

        Bitmap bmp = loadBitmapFromView(this, paintView);

//

        imageView.setImageBitmap(bmp);
        paintView.setVisibility(View.GONE);
//        try {
//            Thread.sleep(4000);
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        tick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                paintView.clear();
                finish();
            }
        });
    }
//

    //
    public static Bitmap loadBitmapFromView(Context context, View v) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        v.measure(View.MeasureSpec.makeMeasureSpec(dm.widthPixels, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(dm.heightPixels, View.MeasureSpec.EXACTLY));
        v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
        Bitmap returnedBitmap = Bitmap.createBitmap(v.getMeasuredWidth(),
                v.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(returnedBitmap);
        v.draw(c);

        return returnedBitmap;
    }


}