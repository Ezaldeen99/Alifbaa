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
        Bitmap bmp = ConvertViewToBitmap(this, paintView);

        imageView.setImageBitmap(bmp);
        paintView.setVisibility(View.GONE);

        tick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

    public static Bitmap ConvertViewToBitmap(Context context, View v) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        v.measure(View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, View.MeasureSpec.EXACTLY));
        v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
        Bitmap bitmap = Bitmap.createBitmap(v.getMeasuredWidth(),
                v.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        v.draw(canvas);
        return bitmap;
    }

}