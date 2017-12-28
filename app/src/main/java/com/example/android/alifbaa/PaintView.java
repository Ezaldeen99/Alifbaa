package com.example.android.alifbaa;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by brayan pc on 12/27/2017.
 */

public class PaintView extends View {
    public static final int BRUSH_SIZE = 50;
    public static final int COLOR = Color.BLACK;
    private static final float TOUCH_TOLERANCE = 4;


//    Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.letter_b);
//    Bitmap mutableBitmap = bmp.copy(Bitmap.Config.ARGB_8888, true);


    private float mX, mY;
    private Path mPath;
    private Paint mPaint;

    private ArrayList<TouchTrace> paths = new ArrayList<>();
    private int currentColor;
    private int strokeWidth;

    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Paint mBitmapPaint = new Paint(Paint.DITHER_FLAG);

    public PaintView(Context context) {
        super(context);
    }

    public PaintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(COLOR);
        mPaint.setStyle(Paint.Style.STROKE);


    }

    public void init(DisplayMetrics metrics) {


//        mCanvas = new Canvas(mutableBitmap);

        int height = metrics.heightPixels;
        int width = metrics.widthPixels;

        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);

        currentColor = COLOR;
        strokeWidth = BRUSH_SIZE;


    }

    public void clear(DisplayMetrics metrics) {

//        mCanvas = new Canvas(mutableBitmap);

        int height = metrics.heightPixels;
        int width = metrics.widthPixels;

        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
        paths.clear();
        invalidate();

    }


    @Override
    protected void onDraw(Canvas canvas) {

        mCanvas.drawColor(Color.TRANSPARENT);

        for (TouchTrace Tt : paths) {
            mPaint.setColor(Tt.color);
            mPaint.setStrokeWidth(Tt.strokeWidth);
            mCanvas.drawPath(Tt.path, mPaint);

        }


//        canvas.drawBitmap(mutableBitmap, 0, 0, mBitmapPaint);

        canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);

        canvas.restore();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Bitmap bmp;
        int x = (int) event.getX();
        int y = (int) event.getY();

        Viewbitmap viewbitmap = new Viewbitmap();
        bmp = viewbitmap.getMbitmap();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
//                touchStart(x, y);
                mPath = new Path();
                TouchTrace fp = new TouchTrace(currentColor, strokeWidth, mPath);
                paths.add(fp);
                mPath.moveTo(x, y);
                mX = x;
                mY = y;
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
//                touchMove(x, y);
                float dx = Math.abs(x - mX);
                float dy = Math.abs(y - mY);

                int color = Color.rgb(34, 47, 96);
                int color2 = Color.rgb(5, 64, 96);
                if (x < bmp.getWidth() && x > 0 && y > 0 && y < bmp.getHeight()) {

                    int pixel = bmp.getPixel(x, y);
                    if (color2 <= pixel && pixel <= color)
                        currentColor = Color.RED;
                    else
                        currentColor = Color.BLACK;
                }

                if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
                    mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
                    mX = x;
                    mY = y;


                }
                invalidate();
                break;


        }

        return true;
    }


//    private void touchStart(float x, float y) {
//        mPath = new Path();
//        TouchTrace fp = new TouchTrace(currentColor, strokeWidth, mPath);
//        paths.add(fp);
//        mPath.moveTo(x, y);
//        mX = x;
//        mY = y;
//    }
    /////////////////////////////////////////////////
//    private void touchMove(int x, int y) {
//        float dx = Math.abs(x - mX);
//        float dy = Math.abs(y - mY);
//
//        int color = Color.rgb(34, 47, 96);
//        int color2 = Color.rgb(5, 64, 96);
//        if (x < bmp.getWidth() && x > 0 && y > 0 && y < bmp.getHeight()) {
//
//            int pixel = bmp.getPixel(x, y);
//            if (color2 <= pixel && pixel <= color)
//                currentColor = Color.RED;
//            else
//                currentColor = Color.BLACK;
//        }
//
//        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
//            mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
//            mX = x;
//            mY = y;
//
//
//
//
//        }
//    }
    ///////////////////////////////////////
}
