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
import android.view.View;

import java.util.ArrayList;

/**
 * Created by brayan pc on 1/28/2018.
 */

public class PaintViewResult extends View {


    public static final int BRUSH_SIZE = 10;
    public static final int COLOR = Color.RED;

    private Paint mPaint;
    PaintView paintView=new PaintView(getContext());

    public static ArrayList<TouchTrace> getPaths() {
        return paths;
    }

    public static void setPaths(ArrayList<TouchTrace> paths) {
        PaintViewResult.paths = paths;
    }

    public static ArrayList<TouchTrace> paths;

    private int currentColor;
    private int strokeWidth;

    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Paint mBitmapPaint = new Paint(Paint.DITHER_FLAG);

    public PaintViewResult(Context context) {
        super(context);

    }
    public PaintViewResult(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setColor(COLOR);
        mPaint.setStyle(Paint.Style.STROKE);


    }

    public void init(DisplayMetrics metrics) {
        int height = metrics.heightPixels;
        int width = metrics.widthPixels;

        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);

        currentColor =COLOR;
        strokeWidth = BRUSH_SIZE;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mCanvas.drawColor(Color.CYAN);
        Log.e("pppppppppppppppvv", paths+ "-");
        if (    paths==null)
            Log.e("mmmmmmmmmmmmmmmnbnvcx", "null");
        for (TouchTrace Tt : paths) {
            mPaint.setColor(COLOR);
            mPaint.setStrokeWidth(Tt.strokeWidth);
            mCanvas.drawPath(Tt.path, mPaint);

        }

        canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);
        Paint painttt = new Paint();
        painttt.setStyle(Paint.Style.STROKE);
        painttt.setColor(Color.WHITE);
        painttt.setStrokeWidth(10);
        Path pathttt = new Path();
        pathttt.moveTo(10, 10);
        pathttt.lineTo(100,100);
//
//        pathttt.cubicTo(x1, y1, x2, y2, x3, y3);
//
        canvas.drawPath(pathttt, painttt);

    }

}