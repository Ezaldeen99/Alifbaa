package com.example.android.alifbaa;

import android.content.Context;
import android.content.Intent;
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

import java.util.ArrayList;


public class PaintView extends View {
    Bitmap bmp;
    Viewbitmap viewbitmap = new Viewbitmap();


    int counter = 1;


    TouchTrace fp;
    private ArrayList<Points> xypoint;
    int counter2;


    public static final int BRUSH_SIZE = 10;
    public static final int COLOR = Color.TRANSPARENT;
    private static final float TOUCH_TOLERANCE = 4;

    private float mX, mY, mxr, myr;

    private Path mPath;
    private Paint mPaint;

    private static ArrayList<TouchTrace> paths = new ArrayList<>();


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

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }


    //this to initalize the paintview when first created
    public void init(DisplayMetrics metrics) {
        Log.e("cccccccccccccccinit", counter + "");

        int height = metrics.heightPixels;
        int width = metrics.widthPixels;
//this takes the screen width and height to create a bitmap which fill up the whole screen
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
//this will create the canvas that contain the bitmap
        currentColor = COLOR;
        strokeWidth = BRUSH_SIZE;
        xypoint = lettersPoint(counter);
        counter2 = xypoint.size();
        if (counter == 0 || counter == 1) {
            counter = 1;
        } else
            counter = viewbitmap.getCounter();
    }

    public void clear(DisplayMetrics metrics) {

        int height = metrics.heightPixels;
        int width = metrics.widthPixels;
//when clicking on the earser this will clear the screen
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
        paths.clear();
        invalidate();
    }

    public ArrayList lettersPoint(int c) {

        ArrayList<Points> xypoints = new ArrayList<>();


        switch (c) {

            case 1:
                float xa0 = Dimensions.DpToPix(166, getContext());
                float ya0 = Dimensions.DpToPix(215, getContext());
                float xa1 = Dimensions.DpToPix(166, getContext());
                float ya1 = Dimensions.DpToPix(400, getContext());

                Points pa0 = new Points(Math.round(xa0), Math.round(ya0));
                xypoints.add(pa0);
                Points pa1 = new Points(Math.round(xa1), Math.round(ya1));
                xypoints.add(pa1);


                break;
            case 2:
                float xb0 = Dimensions.DpToPix(60, getContext());
                float yb0 = Dimensions.DpToPix(233, getContext());
                float xb1 = Dimensions.DpToPix(160, getContext());
                float yb1 = Dimensions.DpToPix(300, getContext());
                float xb2 = Dimensions.DpToPix(276, getContext());
                float yb2 = Dimensions.DpToPix(233, getContext());
                float xb3 = Dimensions.DpToPix(153, getContext());
                float yb3 = Dimensions.DpToPix(366, getContext());

                Points pb0 = new Points(Math.round(xb0), Math.round(yb0));
                xypoints.add(pb0);
                Points pb1 = new Points(Math.round(xb1), Math.round(yb1));
                xypoints.add(pb1);
                Points pb2 = new Points(Math.round(xb2), Math.round(yb2));
                xypoints.add(pb2);
                Points pb3 = new Points(Math.round(xb3), Math.round(yb3));
                xypoints.add(pb3);
                break;

            case 3:
                float xc0 = Dimensions.DpToPix(193, getContext());
                float yc0 = Dimensions.DpToPix(233, getContext());
                float xc1 = Dimensions.DpToPix(150, getContext());
                float yc1 = Dimensions.DpToPix(233, getContext());
                float xc2 = Dimensions.DpToPix(290, getContext());
                float yc2 = Dimensions.DpToPix(300, getContext());
                float xc3 = Dimensions.DpToPix(63, getContext());
                float yc3 = Dimensions.DpToPix(300, getContext());
                float xc4 = Dimensions.DpToPix(173, getContext());
                float yc4 = Dimensions.DpToPix(366, getContext());

                Points pc0 = new Points(Math.round(xc0), Math.round(yc0));
                xypoints.add(pc0);
                Points pc1 = new Points(Math.round(xc1), Math.round(yc1));
                xypoints.add(pc1);
                Points pc2 = new Points(Math.round(xc2), Math.round(yc2));
                xypoints.add(pc2);
                Points pc3 = new Points(Math.round(xc3), Math.round(yc3));
                xypoints.add(pc3);
                Points pc4 = new Points(Math.round(xc4), Math.round(yc4));
                xypoints.add(pc4);
                break;
            case 4:
                float xd0 = Dimensions.DpToPix(193, getContext());
                float yd0 = Dimensions.DpToPix(233, getContext());
                float xd1 = Dimensions.DpToPix(150, getContext());
                float yd1 = Dimensions.DpToPix(233, getContext());
                float xd2 = Dimensions.DpToPix(290, getContext());
                float yd2 = Dimensions.DpToPix(300, getContext());
                float xd3 = Dimensions.DpToPix(63, getContext());
                float yd3 = Dimensions.DpToPix(300, getContext());
                float xd4 = Dimensions.DpToPix(173, getContext());
                float yd4 = Dimensions.DpToPix(366, getContext());

                Points pd0 = new Points(Math.round(xd0), Math.round(yd0));
                xypoints.add(pd0);
                Points pd1 = new Points(Math.round(xd1), Math.round(yd1));
                xypoints.add(pd1);
                Points pd2 = new Points(Math.round(xd2), Math.round(yd2));
                xypoints.add(pd2);
                Points pd3 = new Points(Math.round(xd3), Math.round(yd3));
                xypoints.add(pd3);
                Points pd4 = new Points(Math.round(xd4), Math.round(yd4));
                xypoints.add(pd4);
                Points pd5 = new Points(Math.round(xd4), Math.round(yd4));
                xypoints.add(pd5);
                break;

            case 5:
                float xe0 = Dimensions.DpToPix(115, getContext());
                float ye0 = Dimensions.DpToPix(210, getContext());
                float xe1 = Dimensions.DpToPix(235, getContext());
                float ye1 = Dimensions.DpToPix(230, getContext());
                float xe2 = Dimensions.DpToPix(106, getContext());
                float ye2 = Dimensions.DpToPix(333, getContext());
                float xe3 = Dimensions.DpToPix(183, getContext());
                float ye3 = Dimensions.DpToPix(323, getContext());


                Points pe0 = new Points(Math.round(xe0), Math.round(ye0));
                xypoints.add(pe0);
                Points pe1 = new Points(Math.round(xe1), Math.round(ye1));
                xypoints.add(pe1);
                Points pe2 = new Points(Math.round(xe2), Math.round(ye2));
                xypoints.add(pe2);
                Points pe3 = new Points(Math.round(xe3), Math.round(ye3));
                xypoints.add(pe3);

                break;

            case 6:
                float xf0 = Dimensions.DpToPix(115, getContext());
                float yf0 = Dimensions.DpToPix(210, getContext());
                float xf1 = Dimensions.DpToPix(235, getContext());
                float yf1 = Dimensions.DpToPix(230, getContext());
                float xf2 = Dimensions.DpToPix(106, getContext());
                float yf2 = Dimensions.DpToPix(333, getContext());


                Points pf0 = new Points(Math.round(xf0), Math.round(yf0));
                xypoints.add(pf0);
                Points pf1 = new Points(Math.round(xf1), Math.round(yf1));
                xypoints.add(pf1);
                Points pf2 = new Points(Math.round(xf2), Math.round(yf2));
                xypoints.add(pf2);

                break;
            case 7:
                float xg0 = Dimensions.DpToPix(115, getContext());
                float yg0 = Dimensions.DpToPix(210, getContext());
                float xg1 = Dimensions.DpToPix(235, getContext());
                float yg1 = Dimensions.DpToPix(230, getContext());
                float xg2 = Dimensions.DpToPix(106, getContext());
                float yg2 = Dimensions.DpToPix(333, getContext());
                float xg3 = Dimensions.DpToPix(150, getContext());
                float yg3 = Dimensions.DpToPix(183, getContext());

                Points pg0 = new Points(Math.round(xg0), Math.round(yg0));
                xypoints.add(pg0);
                Points pg1 = new Points(Math.round(xg1), Math.round(yg1));
                xypoints.add(pg1);
                Points pg2 = new Points(Math.round(xg2), Math.round(yg2));
                xypoints.add(pg2);
                Points pg3 = new Points(Math.round(xg3), Math.round(yg3));
                xypoints.add(pg3);
                break;
            case 8:
//                dal
                float xh0 = Dimensions.DpToPix(190, getContext());
                float yh0 = Dimensions.DpToPix(283, getContext());
//                float xh1 = Dimensions.DpToPix(223, getContext());
//                float yh1 = Dimensions.DpToPix(353, getContext());
                float xh2 = Dimensions.DpToPix(146, getContext());
                float yh2 = Dimensions.DpToPix(383, getContext());


                Points ph0 = new Points(Math.round(xh0), Math.round(yh0));
                xypoints.add(ph0);
//                Points ph1 = new Points(Math.round(xh1), Math.round(yh1));
//                xypoints.add(ph1);
                Points ph2 = new Points(Math.round(xh2), Math.round(yh2));
                xypoints.add(ph2);

                break;
//thal
            case 9:
                float xi0 = Dimensions.DpToPix(190, getContext());
                float yi0 = Dimensions.DpToPix(283, getContext());
                float xi1 = Dimensions.DpToPix(223, getContext());
                float yi1 = Dimensions.DpToPix(353, getContext());
                float xi2 = Dimensions.DpToPix(146, getContext());
                float yi2 = Dimensions.DpToPix(383, getContext());
                float xi3 = Dimensions.DpToPix(150, getContext());
                float yi3 = Dimensions.DpToPix(233, getContext());

                Points pi0 = new Points(Math.round(xi0), Math.round(yi0));
                xypoints.add(pi0);
                Points pi1 = new Points(Math.round(xi1), Math.round(yi1));
                xypoints.add(pi1);
                Points pi2 = new Points(Math.round(xi2), Math.round(yi2));
                xypoints.add(pi2);
                Points pi3 = new Points(Math.round(xi3), Math.round(yi3));
                xypoints.add(pi3);

                break;
            case 10:
//                raa
                float xj0 = Dimensions.DpToPix(193, getContext());
                float yj0 = Dimensions.DpToPix(240, getContext());
                float xj1 = Dimensions.DpToPix(115, getContext());
                float yj1 = Dimensions.DpToPix(373, getContext());


                Points pj0 = new Points(Math.round(xj0), Math.round(yj0));
                xypoints.add(pj0);
                Points pj1 = new Points(Math.round(xj1), Math.round(yj1));
                xypoints.add(pj1);


                break;
//                zaa
            case 11:
                float xk0 = Dimensions.DpToPix(193, getContext());
                float yk0 = Dimensions.DpToPix(240, getContext());
                float xk1 = Dimensions.DpToPix(115, getContext());
                float yk1 = Dimensions.DpToPix(373, getContext());
                float xk2 = Dimensions.DpToPix(196, getContext());
                float yk2 = Dimensions.DpToPix(210, getContext());


                Points pk0 = new Points(Math.round(xk0), Math.round(yk0));
                xypoints.add(pk0);
                Points pk1 = new Points(Math.round(xk1), Math.round(yk1));
                xypoints.add(pk1);
                Points pk2 = new Points(Math.round(xk2), Math.round(yk2));
                xypoints.add(pk2);


                break;
            case 12:
                float xseen0 = Dimensions.DpToPix(316, getContext());
                float yseen0 = Dimensions.DpToPix(293, getContext());
                float xseen1 = Dimensions.DpToPix(253, getContext());
                float yseen1 = Dimensions.DpToPix(310, getContext());
                float xseen2 = Dimensions.DpToPix(183, getContext());
                float yseen2 = Dimensions.DpToPix(216, getContext());
                float xseen3 = Dimensions.DpToPix(115, getContext());
                float yseen3 = Dimensions.DpToPix(433, getContext());
                float xseen4 = Dimensions.DpToPix(40, getContext());
                float yseen4 = Dimensions.DpToPix(360, getContext());

                Points pseen0 = new Points(Math.round(xseen0), Math.round(yseen0));
                xypoints.add(pseen0);
                Points pseen1 = new Points(Math.round(xseen1), Math.round(yseen1));
                xypoints.add(pseen1);
                Points pseen2 = new Points(Math.round(xseen2), Math.round(yseen2));
                xypoints.add(pseen2);
                Points pseen3 = new Points(Math.round(xseen3), Math.round(yseen3));
                xypoints.add(pseen3);
                Points pseen4 = new Points(Math.round(xseen4), Math.round(yseen4));
                xypoints.add(pseen4);
                break;
            case 13:
                float xsheen0 = Dimensions.DpToPix(316, getContext());
                float ysheen0 = Dimensions.DpToPix(293, getContext());
                float xsheen1 = Dimensions.DpToPix(253, getContext());
                float ysheen1 = Dimensions.DpToPix(310, getContext());
                float xsheen2 = Dimensions.DpToPix(183, getContext());
                float ysheen2 = Dimensions.DpToPix(216, getContext());
                float xsheen3 = Dimensions.DpToPix(115, getContext());
                float ysheen3 = Dimensions.DpToPix(433, getContext());
                float xsheen4 = Dimensions.DpToPix(40, getContext());
                float ysheen4 = Dimensions.DpToPix(360, getContext());
                float xsheen5 = Dimensions.DpToPix(266, getContext());
                float ysheen5 = Dimensions.DpToPix(240, getContext());
                float xsheen6 = Dimensions.DpToPix(250, getContext());
                float ysheen6 = Dimensions.DpToPix(186, getContext());
                float xsheen7 = Dimensions.DpToPix(233, getContext());
                float ysheen7 = Dimensions.DpToPix(340, getContext());
                Points psheen0 = new Points(Math.round(xsheen0), Math.round(ysheen0));
                xypoints.add(psheen0);
                Points psheen1 = new Points(Math.round(xsheen1), Math.round(ysheen1));
                xypoints.add(psheen1);
                Points psheen2 = new Points(Math.round(xsheen2), Math.round(ysheen2));
                xypoints.add(psheen2);
                Points psheen3 = new Points(Math.round(xsheen3), Math.round(ysheen3));
                xypoints.add(psheen3);
                Points psheen4 = new Points(Math.round(xsheen4), Math.round(ysheen4));
                xypoints.add(psheen4);
                Points psheen5 = new Points(Math.round(xsheen5), Math.round(ysheen5));
                xypoints.add(psheen5);
                Points psheen6 = new Points(Math.round(xsheen6), Math.round(ysheen6));
                xypoints.add(psheen6);
                Points psheen7 = new Points(Math.round(xsheen7), Math.round(ysheen7));
                xypoints.add(psheen7);
                break;
            case 14:
//                sad
                float xsad0 = Dimensions.DpToPix(220, getContext());
                float ysad0 = Dimensions.DpToPix(293, getContext());
                float xsad1 = Dimensions.DpToPix(326, getContext());
                float ysad1 = Dimensions.DpToPix(293, getContext());
                float xsad2 = Dimensions.DpToPix(213, getContext());
                float ysad2 = Dimensions.DpToPix(306, getContext());
                float xsad3 = Dimensions.DpToPix(133, getContext());
                float ysad3 = Dimensions.DpToPix(403, getContext());
                float xsad4 = Dimensions.DpToPix(133, getContext());
                float ysad4 = Dimensions.DpToPix(403, getContext());
                float xsad5 = Dimensions.DpToPix(26, getContext());
                float ysad5 = Dimensions.DpToPix(336, getContext());

                Points psad0 = new Points(Math.round(xsad0), Math.round(ysad0));
                xypoints.add(psad0);
                Points psad1 = new Points(Math.round(xsad1), Math.round(ysad1));
                xypoints.add(psad1);
                Points psad2 = new Points(Math.round(xsad2), Math.round(ysad2));
                xypoints.add(psad2);
                Points psad3 = new Points(Math.round(xsad3), Math.round(ysad3));
                xypoints.add(psad3);
                Points psad4 = new Points(Math.round(xsad4), Math.round(ysad4));
                xypoints.add(psad4);
                Points psad5 = new Points(Math.round(xsad5), Math.round(ysad5));
                xypoints.add(psad5);
                break;
            case 15:
//                thad
                float xthad0 = Dimensions.DpToPix(220, getContext());
                float ythad0 = Dimensions.DpToPix(293, getContext());
                float xthad1 = Dimensions.DpToPix(326, getContext());
                float ythad1 = Dimensions.DpToPix(293, getContext());
                float xthad2 = Dimensions.DpToPix(213, getContext());
                float ythad2 = Dimensions.DpToPix(306, getContext());
                float xthad3 = Dimensions.DpToPix(133, getContext());
                float ythad3 = Dimensions.DpToPix(403, getContext());
                float xthad4 = Dimensions.DpToPix(133, getContext());
                float ythad4 = Dimensions.DpToPix(403, getContext());
                float xthad5 = Dimensions.DpToPix(26, getContext());
                float ythad5 = Dimensions.DpToPix(336, getContext());
                float xthad6 = Dimensions.DpToPix(266, getContext());
                float ythad6 = Dimensions.DpToPix(196, getContext());
                Points pthad0 = new Points(Math.round(xthad0), Math.round(ythad0));
                xypoints.add(pthad0);
                Points pthad1 = new Points(Math.round(xthad1), Math.round(ythad1));
                xypoints.add(pthad1);
                Points pthad2 = new Points(Math.round(xthad2), Math.round(ythad2));
                xypoints.add(pthad2);
                Points pthad3 = new Points(Math.round(xthad3), Math.round(ythad3));
                xypoints.add(pthad3);
                Points pthad4 = new Points(Math.round(xthad4), Math.round(ythad4));
                xypoints.add(pthad4);
                Points pthad5 = new Points(Math.round(xthad5), Math.round(ythad5));
                xypoints.add(pthad5);
                Points pthad6 = new Points(Math.round(xthad6), Math.round(ythad6));
                xypoints.add(pthad6);
                break;
            case 16:
                float xtah0 = Dimensions.DpToPix(150, getContext());
                float ytah0 = Dimensions.DpToPix(396, getContext());
                float xtah1 = Dimensions.DpToPix(150, getContext());
                float ytah1 = Dimensions.DpToPix(233, getContext());
                float xtah2 = Dimensions.DpToPix(250, getContext());
                float ytah2 = Dimensions.DpToPix(343, getContext());
                float xtah3 = Dimensions.DpToPix(100, getContext());
                float ytah3 = Dimensions.DpToPix(400, getContext());


                Points ptah0 = new Points(Math.round(xtah0), Math.round(ytah0));
                xypoints.add(ptah0);
                Points ptah1 = new Points(Math.round(xtah1), Math.round(ytah1));
                xypoints.add(ptah1);
                Points ptah2 = new Points(Math.round(xtah2), Math.round(ytah2));
                xypoints.add(ptah2);
                Points ptah3 = new Points(Math.round(xtah3), Math.round(ytah3));
                xypoints.add(ptah3);

                break;
            case 17:
                float xthah0 = Dimensions.DpToPix(150, getContext());
                float ythah0 = Dimensions.DpToPix(396, getContext());
                float xthah1 = Dimensions.DpToPix(150, getContext());
                float ythah1 = Dimensions.DpToPix(233, getContext());
                float xthah2 = Dimensions.DpToPix(250, getContext());
                float ythah2 = Dimensions.DpToPix(343, getContext());
                float xthah3 = Dimensions.DpToPix(100, getContext());
                float ythah3 = Dimensions.DpToPix(400, getContext());
                float xthah4 = Dimensions.DpToPix(243, getContext());
                float ythah4 = Dimensions.DpToPix(256, getContext());

                Points pthah0 = new Points(Math.round(xthah0), Math.round(ythah0));
                xypoints.add(pthah0);
                Points pthah1 = new Points(Math.round(xthah1), Math.round(ythah1));
                xypoints.add(pthah1);
                Points pthah2 = new Points(Math.round(xthah2), Math.round(ythah2));
                xypoints.add(pthah2);
                Points pthah3 = new Points(Math.round(xthah3), Math.round(ythah3));
                xypoints.add(pthah3);
                Points pthah4 = new Points(Math.round(xthah4), Math.round(ythah4));
                xypoints.add(pthah4);
                break;
            case 18:
                float xaeen0 = Dimensions.DpToPix(236, getContext());
                float yaeen0 = Dimensions.DpToPix(210, getContext());
                float xaeen1 = Dimensions.DpToPix(263, getContext());
                float yaeen1 = Dimensions.DpToPix(275, getContext());
                float xaeen2 = Dimensions.DpToPix(145, getContext());
                float yaeen2 = Dimensions.DpToPix(280, getContext());
                float xaeen3 = Dimensions.DpToPix(250, getContext());
                float yaeen3 = Dimensions.DpToPix(430, getContext());
                float xaeen4 = Dimensions.DpToPix(243, getContext());
                float yaeen4 = Dimensions.DpToPix(256, getContext());

                Points paeen0 = new Points(Math.round(xaeen0), Math.round(yaeen0));
                xypoints.add(paeen0);
                Points paeen1 = new Points(Math.round(xaeen1), Math.round(yaeen1));
                xypoints.add(paeen1);
                Points paeen2 = new Points(Math.round(xaeen2), Math.round(yaeen2));
                xypoints.add(paeen2);
                Points paeen3 = new Points(Math.round(xaeen3), Math.round(yaeen3));
                xypoints.add(paeen3);
                Points paeen4 = new Points(Math.round(xaeen4), Math.round(yaeen4));
                xypoints.add(paeen4);
                break;
            case 19:
                float xghaen0 = Dimensions.DpToPix(236, getContext());
                float yghaen0 = Dimensions.DpToPix(210, getContext());
                float xghaen1 = Dimensions.DpToPix(263, getContext());
                float yghaen1 = Dimensions.DpToPix(275, getContext());
                float xghaen2 = Dimensions.DpToPix(145, getContext());
                float yghaen2 = Dimensions.DpToPix(280, getContext());
                float xghaen3 = Dimensions.DpToPix(250, getContext());
                float yghaen3 = Dimensions.DpToPix(430, getContext());
                float xghaen4 = Dimensions.DpToPix(175, getContext());
                float yghaen4 = Dimensions.DpToPix(170, getContext());

                Points pghaen0 = new Points(Math.round(xghaen0), Math.round(yghaen0));
                xypoints.add(pghaen0);
                Points pghaen1 = new Points(Math.round(xghaen1), Math.round(yghaen1));
                xypoints.add(pghaen1);
                Points pghaen2 = new Points(Math.round(xghaen2), Math.round(yghaen2));
                xypoints.add(pghaen2);
                Points pghaen3 = new Points(Math.round(xghaen3), Math.round(yghaen3));
                xypoints.add(pghaen3);
                Points pghaen4 = new Points(Math.round(xghaen4), Math.round(yghaen4));
                xypoints.add(pghaen4);
                break;
            case 20:
                float xphaa0 = Dimensions.DpToPix(236, getContext());
                float yphaa0 = Dimensions.DpToPix(233, getContext());
                float xphaa1 = Dimensions.DpToPix(273, getContext());
                float yphaa1 = Dimensions.DpToPix(343, getContext());
                float xphaa2 = Dimensions.DpToPix(250, getContext());
                float yphaa2 = Dimensions.DpToPix(286, getContext());
                float xphaa3 = Dimensions.DpToPix(166, getContext());
                float yphaa3 = Dimensions.DpToPix(400, getContext());
                float xphaa4 = Dimensions.DpToPix(60, getContext());
                float yphaa4 = Dimensions.DpToPix(400, getContext());

                Points pphaa0 = new Points(Math.round(xphaa0), Math.round(yphaa0));
                xypoints.add(pphaa0);
                Points pphaa1 = new Points(Math.round(xphaa1), Math.round(yphaa1));
                xypoints.add(pphaa1);
                Points pphaa2 = new Points(Math.round(xphaa2), Math.round(yphaa2));
                xypoints.add(pphaa2);
                Points pphaa3 = new Points(Math.round(xphaa3), Math.round(yphaa3));
                xypoints.add(pphaa3);
                Points pphaa4 = new Points(Math.round(xphaa4), Math.round(yphaa4));
                xypoints.add(pphaa4);
                break;
            case 21:
                float xkhaf0 = Dimensions.DpToPix(250, getContext());
                float ykhaf0 = Dimensions.DpToPix(343, getContext());
                float xkhaf1 = Dimensions.DpToPix(180, getContext());
                float ykhaf1 = Dimensions.DpToPix(310, getContext());
                float xkhaf2 = Dimensions.DpToPix(160, getContext());
                float ykhaf2 = Dimensions.DpToPix(425, getContext());
                float xkhaf3 = Dimensions.DpToPix(230, getContext());
                float ykhaf3 = Dimensions.DpToPix(360, getContext());
                float xkhaf4 = Dimensions.DpToPix(230, getContext());
                float ykhaf4 = Dimensions.DpToPix(215, getContext());
                float xkhaf5 = Dimensions.DpToPix(166, getContext());
                float ykhaf5 = Dimensions.DpToPix(215, getContext());
                Points pkhaf0 = new Points(Math.round(xkhaf0), Math.round(ykhaf0));
                xypoints.add(pkhaf0);
                Points pkhaf1 = new Points(Math.round(xkhaf1), Math.round(ykhaf1));
                xypoints.add(pkhaf1);
                Points pkhaf2 = new Points(Math.round(xkhaf2), Math.round(ykhaf2));
                xypoints.add(pkhaf2);
                Points pkhaf3 = new Points(Math.round(xkhaf3), Math.round(ykhaf3));
                xypoints.add(pkhaf3);
                Points pkhaf4 = new Points(Math.round(xkhaf4), Math.round(ykhaf4));
                xypoints.add(pkhaf4);
                Points pkhaf5 = new Points(Math.round(xkhaf5), Math.round(ykhaf5));
                xypoints.add(pkhaf5);
                break;
            case 22:
                float xkaf0 = Dimensions.DpToPix(290, getContext());
                float ykaf0 = Dimensions.DpToPix(230, getContext());
                float xkaf1 = Dimensions.DpToPix(180, getContext());
                float ykaf1 = Dimensions.DpToPix(266, getContext());
                float xkaf2 = Dimensions.DpToPix(250, getContext());
                float ykaf2 = Dimensions.DpToPix(366, getContext());
                float xkaf3 = Dimensions.DpToPix(33, getContext());
                float ykaf3 = Dimensions.DpToPix(380, getContext());


                Points pkaf0 = new Points(Math.round(xkaf0), Math.round(ykaf0));
                xypoints.add(pkaf0);
                Points pkaf1 = new Points(Math.round(xkaf1), Math.round(ykaf1));
                xypoints.add(pkaf1);
                Points pkaf2 = new Points(Math.round(xkaf2), Math.round(ykaf2));
                xypoints.add(pkaf2);
                Points pkaf3 = new Points(Math.round(xkaf3), Math.round(ykaf3));
                xypoints.add(pkaf3);

                break;
            case 23:
                float xlam0 = Dimensions.DpToPix(220, getContext());
                float ylam0 = Dimensions.DpToPix(230, getContext());
                float xlam1 = Dimensions.DpToPix(155, getContext());
                float ylam1 = Dimensions.DpToPix(415, getContext());
                float xlam2 = Dimensions.DpToPix(90, getContext());
                float ylam2 = Dimensions.DpToPix(360, getContext());


                Points plam0 = new Points(Math.round(xlam0), Math.round(ylam0));
                xypoints.add(plam0);
                Points plam1 = new Points(Math.round(xlam1), Math.round(ylam1));
                xypoints.add(plam1);
                Points plam2 = new Points(Math.round(xlam2), Math.round(ylam2));
                xypoints.add(plam2);

                break;
            case 24:
                float xmeem0 = Dimensions.DpToPix(175, getContext());
                float ymeem0 = Dimensions.DpToPix(260, getContext());
                float xmeem1 = Dimensions.DpToPix(240, getContext());
                float ymeem1 = Dimensions.DpToPix(260, getContext());
                float xmeem2 = Dimensions.DpToPix(150, getContext());
                float ymeem2 = Dimensions.DpToPix(400, getContext());


                Points pmeem0 = new Points(Math.round(xmeem0), Math.round(ymeem0));
                xypoints.add(pmeem0);
                Points pmeem1 = new Points(Math.round(xmeem1), Math.round(ymeem1));
                xypoints.add(pmeem1);
                Points pmeem2 = new Points(Math.round(xmeem2), Math.round(ymeem2));
                xypoints.add(pmeem2);

                break;
            case 25:
                float xnoon0 = Dimensions.DpToPix(260, getContext());
                float ynoon0 = Dimensions.DpToPix(300, getContext());
                float xnoon1 = Dimensions.DpToPix(125, getContext());
                float ynoon1 = Dimensions.DpToPix(320, getContext());
                float xnoon2 = Dimensions.DpToPix(200, getContext());
                float ynoon2 = Dimensions.DpToPix(230, getContext());


                Points pnoon0 = new Points(Math.round(xnoon0), Math.round(ynoon0));
                xypoints.add(pnoon0);
                Points pnoon1 = new Points(Math.round(xnoon1), Math.round(ynoon1));
                xypoints.add(pnoon1);
                Points pnoon2 = new Points(Math.round(xnoon2), Math.round(ynoon2));
                xypoints.add(pnoon2);

                break;
            case 26:
                float xwao0 = Dimensions.DpToPix(220, getContext());
                float ywao0 = Dimensions.DpToPix(310, getContext());
                float xwao1 = Dimensions.DpToPix(190, getContext());
                float ywao1 = Dimensions.DpToPix(250, getContext());
                float xwao2 = Dimensions.DpToPix(160, getContext());
                float ywao2 = Dimensions.DpToPix(370, getContext());


                Points pwao0 = new Points(Math.round(xwao0), Math.round(ywao0));
                xypoints.add(pwao0);
                Points pwao1 = new Points(Math.round(xwao1), Math.round(ywao1));
                xypoints.add(pwao1);
                Points pwao2 = new Points(Math.round(xwao2), Math.round(ywao2));
                xypoints.add(pwao2);

                break;

            case 27:
                float xhaa0 = Dimensions.DpToPix(170, getContext());
                float yhaa0 = Dimensions.DpToPix(266, getContext());
                float xhaa1 = Dimensions.DpToPix(170, getContext());
                float yhaa1 = Dimensions.DpToPix(340, getContext());


                Points phaa0 = new Points(Math.round(xhaa0), Math.round(yhaa0));
                xypoints.add(phaa0);
                Points phaa1 = new Points(Math.round(xhaa1), Math.round(yhaa1));
                xypoints.add(phaa1);
                Points phaa2 = new Points(Math.round(xhaa0), Math.round(yhaa0));
                xypoints.add(phaa2);

                break;
            case 28:
                float xyaa0 = Dimensions.DpToPix(270, getContext());
                float yyaa0 = Dimensions.DpToPix(220, getContext());
                float xyaa1 = Dimensions.DpToPix(190, getContext());
                float yyaa1 = Dimensions.DpToPix(280, getContext());
                float xyaa2 = Dimensions.DpToPix(180, getContext());
                float yyaa2 = Dimensions.DpToPix(380, getContext());
                float xyaa3 = Dimensions.DpToPix(100, getContext());
                float yyaa3 = Dimensions.DpToPix(300, getContext());
                float xyaa4 = Dimensions.DpToPix(325, getContext());
                float yyaa4 = Dimensions.DpToPix(430, getContext());
                float xyaa5 = Dimensions.DpToPix(90, getContext());
                float yyaa5 = Dimensions.DpToPix(430, getContext());

                Points pyaa0 = new Points(Math.round(xyaa0), Math.round(yyaa0));
                xypoints.add(pyaa0);
                Points pyaa1 = new Points(Math.round(xyaa1), Math.round(yyaa1));
                xypoints.add(pyaa1);
                Points pyaa2 = new Points(Math.round(xyaa2), Math.round(yyaa2));
                xypoints.add(pyaa2);
                Points pyaa3 = new Points(Math.round(xyaa3), Math.round(yyaa3));
                xypoints.add(pyaa2);
                Points pyaa4 = new Points(Math.round(xyaa4), Math.round(yyaa4));
                xypoints.add(pyaa2);
                Points pyaa5 = new Points(Math.round(xyaa5), Math.round(yyaa5));
                xypoints.add(pyaa2);

                break;
        }

        return xypoints;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int g = 0;
        mCanvas.drawColor(Color.TRANSPARENT);

        for (TouchTrace Tt : paths) {
            mPaint.setColor(Tt.color);
            mPaint.setStrokeWidth(Tt.strokeWidth);
            mCanvas.drawPath(Tt.path, mPaint);

        }

        canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);
//      canvas.restore();

        Paint painttt = new Paint();
        painttt.setStyle(Paint.Style.STROKE);
        painttt.setColor(Color.WHITE);
        painttt.setStrokeWidth(10);


    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();
        Log.e("mmmmmmmmmmmmmmm", x + "-" + y);

        if (bmp == null) {
            bmp = LetterTrackingActivity.viewbitmap.getMbitmap();
        } else {
            bmp = LetterTrackingActivity.viewbitmap.getMbitmap();
        }

        //to get the bitmap which was generated from converting the image view


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
                        mxr = x;
                        myr = y;
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
                float dxdraw = Math.abs(x - mxr);
                float dydraw = Math.abs(y - myr);

                if (x < bmp.getWidth() && x > 0 && y > 0 && y < bmp.getHeight()) {
                    int pixel = bmp.getPixel(x, y);
                    Log.e("bbbbbbbbbbb", pixel + "");


                    String hexColor = String.format("#%06X", (0xFFFFFF & pixel));
                    Log.e("ddddddddddd", hexColor);

                    Log.e("mmmmmmmmmmmmmmm", x + "-" + y);
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

                Log.e("NNNNNNNNNNND", x + "-" + y);

                Log.e("sssssssssssssize", counter2 + "");
                float urx;
                float ury;
                for (Points points1 : xypoint) {

                    if (((points1.getX() - 30) <= x && x <= (points1.getX() + 30)) && ((points1.getY() - 30) <= y && y <= (points1.getY() + 30))) {

                        if (dxdraw > 30 || dydraw > 30) {
                            counter2--;
                            Log.e("jjjjjjjjjjjjj", counter2 + "");
                        }
                        if (counter2 == 0) {
                            PaintViewResult paintViewResult = new PaintViewResult(getContext());
                            paintViewResult.setPaths(paths);
                            Intent n = new Intent(getContext(), BlackBoardActivity.class);
                            getContext().startActivity(n);

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            counter++;
                            viewbitmap.setCounter(counter);


                        }

                    }
                }

                break;
            case MotionEvent.ACTION_UP:
                mxr = x;
                myr = y;
                break;

        }


        return true;
    }


}
