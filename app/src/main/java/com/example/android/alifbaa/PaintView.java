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
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.io.IOException;
import java.util.ArrayList;



public class PaintView extends View {
    Bitmap bmp;
    public static final int BRUSH_SIZE = 10;
    public static final int COLOR = Color.TRANSPARENT;
    private static final float TOUCH_TOLERANCE = 4;

    private float mX, mY;
    private Path mPath;
    private Paint mPaint;

    private ArrayList<TouchTrace> paths = new ArrayList<>();
    private int currentColor;
    private int strokeWidth;

    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Canvas cCanvas;
    private Paint mBitmapPaint = new Paint(Paint.DITHER_FLAG);
    TouchTrace fp;

    public PaintView(Context context) {
        super(context);
    }

    public PaintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(COLOR);
        mPaint.setStyle(Paint.Style.STROKE);


    }

    //this to initalize the paintview when first created
    public void init(DisplayMetrics metrics) {


        int height = metrics.heightPixels;
        int width = metrics.widthPixels;
//this takes the screen width and height to create a bitmap which fill up the whole screen
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
//this will create the canvas that contai the bitmap
        currentColor = COLOR;
        strokeWidth = BRUSH_SIZE;

    }

    public void clear(DisplayMetrics metrics) {

        int height = metrics.heightPixels;
        int width = metrics.widthPixels;
//when clicking on the earser this will clear the screen
//        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
//        mCanvas = new Canvas(mBitmap);
        paths.clear();
        mCanvas.drawColor(Color.TRANSPARENT);
        invalidate();
    }


    public void create(DisplayMetrics metrics)  {

        int height = metrics.heightPixels;
        int width = metrics.widthPixels;
//this will retrive last path to display it on the black screen

//        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
//        mCanvas = new Canvas(mBitmap);

            mCanvas.drawColor(Color.BLACK);

            for (TouchTrace fb : paths) {
                mPaint.setColor(fb.color);
                mPaint.setStrokeWidth(fb.strokeWidth);
                mCanvas.drawPath(fp.path, mPaint);
            }



        mCanvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);


        try {

            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clear(metrics);





    }











    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mCanvas.drawColor(Color.TRANSPARENT);

        for (TouchTrace Tt : paths) {
            mPaint.setColor(Tt.color);
            mPaint.setStrokeWidth(Tt.strokeWidth);
            mCanvas.drawPath(Tt.path, mPaint);

        }

        canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);
        canvas.restore();

        Paint painttt = new Paint();
        painttt.setStyle(Paint.Style.STROKE);
        painttt.setColor(Color.WHITE);
        painttt.setStrokeWidth(10);
        Path pathttt = new Path();

        float x0 = Dimensions.DpToPix(60, getContext());
        float y0 = Dimensions.DpToPix(233, getContext());
        float x1 = Dimensions.DpToPix(160, getContext());
        float y1 = Dimensions.DpToPix(300, getContext());
        float x2 = Dimensions.DpToPix(276, getContext());
        float y2 = Dimensions.DpToPix(233, getContext());
        float x3 = Dimensions.DpToPix(266, getContext());
        float y3 = Dimensions.DpToPix(216, getContext());





        pathttt.moveTo(x0, y0);

        pathttt.cubicTo( x1,y1,x2,y2,x3,y3);



        canvas.drawPath(pathttt, painttt);

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {


        int x = (int) event.getX();
        int y = (int) event.getY();
        if (LetterTrackingActivity.viewbitmap != null) {
            bmp = LetterTrackingActivity.viewbitmap.getMbitmap();

            //to get the bitmap which was generated from converting the image view

            if (bmp == null) {
                Log.e("bitmap", "null");
            }

            switch (event.getAction()) {

                case MotionEvent.ACTION_DOWN:

                    //when user touch the screen
                    mPath = new Path();

                    //create new path

                    if (x < bmp.getWidth() && x > 0 && y > 0 && y < bmp.getHeight()) {

                        //get the coordinates of the touch event
                        int pixel = bmp.getPixel(x, y);
                        //get the color of the pixel user touched


                        if (pixel != Color.TRANSPARENT && pixel != Color.WHITE)

                        //if pixel is tranparent which mean outside the letter
                        {
                            //add this path to the arraylist of paths
                            currentColor = Color.RED;
                            fp = new TouchTrace(currentColor, strokeWidth, mPath);
                            paths.add(fp);
                            mPath.moveTo(x, y);
                            mX = x;
                            mY = y;
                            invalidate();
                        } else
                            //in this case the user is drawing outside the letter
                            currentColor = COLOR;
                    }


                    break;

                case MotionEvent.ACTION_MOVE:

                    //when user swipe on screen
                    float dx = Math.abs(x - mX);
                    float dy = Math.abs(y - mY);


                    if (x < bmp.getWidth() && x > 0 && y > 0 && y < bmp.getHeight()) {
                        int pixel = bmp.getPixel(x, y);
                        Log.e("bbbbbbbbbbb", pixel + "");

                        String hexColor = String.format("#%06X", (0xFFFFFF & pixel));
                        Log.e("ddddddddddd", hexColor);

                        Log.e("mmmmmmmmmmmmmmm",  x + "-" + y);
                        if (pixel != Color.TRANSPARENT && pixel != Color.WHITE)

                        {
                            //when user swipe on screen the color will change if it will turn transparnt it wont draw
                            currentColor = Color.RED;
                            if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
                                mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
                                mX = x;
                                mY = y;
                            }
                            invalidate();
                        } else {
                            currentColor = COLOR;

                        }
                    }


                    break;
            }


        }
        return true;
    }

}


