package com.example.android.alifbaa;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

public class BlackBoardActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_board);


        PaintViewResult paintView = (PaintViewResult) findViewById(R.id.p);

        final DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);


        paintView.init(metrics);
        ImageView imageView=findViewById(R.id.im);

        Bitmap bmp= loadBitmapFromView(this,paintView);


//        paintView.setVisibility(View.GONE);

        imageView.setImageBitmap(bmp);
        for (int i = 0; i <200 ; i++) {

        }
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        finish();
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