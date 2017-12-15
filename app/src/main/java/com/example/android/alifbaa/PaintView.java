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
 * Created by brayan pc on 12/12/2017.
 */

public class PaintView extends View {

    private float mX, mY;
    private Path mPath;
    private Paint mPaint;
    private ArrayList<TouchTrace> paths = new ArrayList<>();

    private static final int CURRENT_COLOR=Color.WHITE;
    private static final int BG_COLOR = Color.BLACK;
    public static final int BRUSH_SIZE=20;
    private static final float TOUCH_TOLERANCE = 4;
    private int backgroundColor = BG_COLOR;

    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Paint mBitmapPaint = new Paint(Paint.DITHER_FLAG);

    public PaintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(CURRENT_COLOR);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    public PaintView(Context context) {
        this(context,null);
    }

    public void init(DisplayMetrics metrics) {
        int height = metrics.heightPixels;
        int width = metrics.widthPixels;

        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
    }



    public void clear() {
        backgroundColor = BG_COLOR;
        paths.clear();
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        mCanvas.drawColor(backgroundColor);

        for (TouchTrace Tt : paths) {
            mPaint.setColor(Tt.color);
            mPaint.setStrokeWidth(Tt.strokeWidth);
            mCanvas.drawPath(Tt.path, mPaint);

        }

        canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);
        canvas.restore();
    }
    private void paintStart(float x, float y) {
        mPath = new Path();
        TouchTrace touchTrace= new TouchTrace(CURRENT_COLOR, BRUSH_SIZE, mPath);
        paths.add(touchTrace);
        mPath.moveTo(x, y);
        mX = x;
        mY = y;
    }

    private void paintMove(float x, float y) {
        float dx = Math.abs(x - mX);
        float dy = Math.abs(y - mY);

        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
            mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
            mX = x;
            mY = y;
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN :
                paintStart(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE :
                paintMove(x, y);
                invalidate();
                break;
        }

        return true;
    }
}
