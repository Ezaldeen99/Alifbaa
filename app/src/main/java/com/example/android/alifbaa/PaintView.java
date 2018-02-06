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
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;


public class PaintView extends View {
    Bitmap bmp;
    Viewbitmap viewbitmap = new Viewbitmap();
    int lettersCounter = 1;
    private ArrayList<Points> letterXYPoints;
    int letterPointsCounter;
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
        int height = metrics.heightPixels;
        int width = metrics.widthPixels;
//this takes the screen width and height to create a bitmap which fill up the whole screen
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
//this will create the canvas that contain the bitmap
        currentColor = COLOR;
        strokeWidth = BRUSH_SIZE;
        letterXYPoints = lettersPoint(lettersCounter);
        letterPointsCounter = letterXYPoints.size();
        if (lettersCounter == 0 || lettersCounter == 1) {
            lettersCounter = 1;
        } else
            lettersCounter = viewbitmap.getCounter();
    }

    //this to clear the screen and paths when user clicks eraser
    public void clear(DisplayMetrics metrics) {
        int height = metrics.heightPixels;
        int width = metrics.widthPixels;
//when clicking on the eraser this will clear the screen
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
        paths.clear();
        invalidate();
    }

    public ArrayList lettersPoint(int c) {

        ArrayList<Points> lettersXYpoints = new ArrayList<>();


        switch (c) {


            case 1:
                float xalif0 = Dimensions.DpToPix(166, getContext());
                float yalif0 = Dimensions.DpToPix(215, getContext());
                float xalif1 = Dimensions.DpToPix(166, getContext());
                float yalif1 = Dimensions.DpToPix(400, getContext());

                Points palif0 = new Points(Math.round(xalif0), Math.round(yalif0));
                lettersXYpoints.add(palif0);
                Points palif1 = new Points(Math.round(xalif1), Math.round(yalif1));
                lettersXYpoints.add(palif1);


                break;
            case 2:
                float xBaa0 = Dimensions.DpToPix(60, getContext());
                float yBaa0 = Dimensions.DpToPix(233, getContext());
                float xBaa1 = Dimensions.DpToPix(160, getContext());
                float yBaa1 = Dimensions.DpToPix(300, getContext());
                float xBaa2 = Dimensions.DpToPix(276, getContext());
                float yBaa2 = Dimensions.DpToPix(233, getContext());
                float xBaa3 = Dimensions.DpToPix(153, getContext());
                float yBaa3 = Dimensions.DpToPix(366, getContext());

                Points pBaa0 = new Points(Math.round(xBaa0), Math.round(yBaa0));
                lettersXYpoints.add(pBaa0);
                Points pBaa1 = new Points(Math.round(xBaa1), Math.round(yBaa1));
                lettersXYpoints.add(pBaa1);
                Points pBaa2 = new Points(Math.round(xBaa2), Math.round(yBaa2));
                lettersXYpoints.add(pBaa2);
                Points pBaa3 = new Points(Math.round(xBaa3), Math.round(yBaa3));
                lettersXYpoints.add(pBaa3);
                break;

            case 3:
                float xTaa0 = Dimensions.DpToPix(193, getContext());
                float yTaa0 = Dimensions.DpToPix(233, getContext());
                float xTaa1 = Dimensions.DpToPix(150, getContext());
                float yTaa1 = Dimensions.DpToPix(233, getContext());
                float xTaa2 = Dimensions.DpToPix(290, getContext());
                float yTaa2 = Dimensions.DpToPix(300, getContext());
                float xTaa3 = Dimensions.DpToPix(63, getContext());
                float yTaa3 = Dimensions.DpToPix(300, getContext());
                float xTaa4 = Dimensions.DpToPix(173, getContext());
                float yTaa4 = Dimensions.DpToPix(366, getContext());

                Points pTaa0 = new Points(Math.round(xTaa0), Math.round(yTaa0));
                lettersXYpoints.add(pTaa0);
                Points pTaa1 = new Points(Math.round(xTaa1), Math.round(yTaa1));
                lettersXYpoints.add(pTaa1);
                Points pTaa2 = new Points(Math.round(xTaa2), Math.round(yTaa2));
                lettersXYpoints.add(pTaa2);
                Points pTaa3 = new Points(Math.round(xTaa3), Math.round(yTaa3));
                lettersXYpoints.add(pTaa3);
                Points pTaa4 = new Points(Math.round(xTaa4), Math.round(yTaa4));
                lettersXYpoints.add(pTaa4);
                break;
            case 4:
                float xThaa0 = Dimensions.DpToPix(193, getContext());
                float yThaa0 = Dimensions.DpToPix(233, getContext());
                float xThaa1 = Dimensions.DpToPix(150, getContext());
                float yThaa1 = Dimensions.DpToPix(233, getContext());
                float xThaa2 = Dimensions.DpToPix(290, getContext());
                float yThaa2 = Dimensions.DpToPix(300, getContext());
                float xThaa3 = Dimensions.DpToPix(63, getContext());
                float yThaa3 = Dimensions.DpToPix(300, getContext());
                float xThaa4 = Dimensions.DpToPix(173, getContext());
                float yThaa4 = Dimensions.DpToPix(366, getContext());

                Points pThaa0 = new Points(Math.round(xThaa0), Math.round(yThaa0));
                lettersXYpoints.add(pThaa0);
                Points pThaa1 = new Points(Math.round(xThaa1), Math.round(yThaa1));
                lettersXYpoints.add(pThaa1);
                Points pThaa2 = new Points(Math.round(xThaa2), Math.round(yThaa2));
                lettersXYpoints.add(pThaa2);
                Points pThaa3 = new Points(Math.round(xThaa3), Math.round(yThaa3));
                lettersXYpoints.add(pThaa3);
                Points pThaa4 = new Points(Math.round(xThaa4), Math.round(yThaa4));
                lettersXYpoints.add(pThaa4);
                Points pThaa5 = new Points(Math.round(xThaa4), Math.round(yThaa4));
                lettersXYpoints.add(pThaa5);
                break;

            case 5:
                float xGeem0 = Dimensions.DpToPix(115, getContext());
                float yGeem0 = Dimensions.DpToPix(210, getContext());
                float xGeem1 = Dimensions.DpToPix(235, getContext());
                float yGeem1 = Dimensions.DpToPix(230, getContext());
                float xGeem2 = Dimensions.DpToPix(106, getContext());
                float yGeem2 = Dimensions.DpToPix(333, getContext());
                float xGeem3 = Dimensions.DpToPix(183, getContext());
                float yGeem3 = Dimensions.DpToPix(323, getContext());


                Points pGeem0 = new Points(Math.round(xGeem0), Math.round(yGeem0));
                lettersXYpoints.add(pGeem0);
                Points pGeem1 = new Points(Math.round(xGeem1), Math.round(yGeem1));
                lettersXYpoints.add(pGeem1);
                Points pGeem2 = new Points(Math.round(xGeem2), Math.round(yGeem2));
                lettersXYpoints.add(pGeem2);
                Points pGeem3 = new Points(Math.round(xGeem3), Math.round(yGeem3));
                lettersXYpoints.add(pGeem3);

                break;

            case 6:
                float xHaa0 = Dimensions.DpToPix(115, getContext());
                float yHaa0 = Dimensions.DpToPix(210, getContext());
                float xHaa1 = Dimensions.DpToPix(235, getContext());
                float yHaa1 = Dimensions.DpToPix(230, getContext());
                float xHaa2 = Dimensions.DpToPix(106, getContext());
                float yHaa2 = Dimensions.DpToPix(333, getContext());


                Points pHaa0 = new Points(Math.round(xHaa0), Math.round(yHaa0));
                lettersXYpoints.add(pHaa0);
                Points pHaa1 = new Points(Math.round(xHaa1), Math.round(yHaa1));
                lettersXYpoints.add(pHaa1);
                Points pHaa2 = new Points(Math.round(xHaa2), Math.round(yHaa2));
                lettersXYpoints.add(pHaa2);

                break;
            case 7:
                float xKhaa0 = Dimensions.DpToPix(115, getContext());
                float yKhaa0 = Dimensions.DpToPix(210, getContext());
                float xKhaa1 = Dimensions.DpToPix(235, getContext());
                float yKhaa1 = Dimensions.DpToPix(230, getContext());
                float xKhaa2 = Dimensions.DpToPix(106, getContext());
                float yKhaa2 = Dimensions.DpToPix(333, getContext());
                float xKhaa3 = Dimensions.DpToPix(150, getContext());
                float yKhaa3 = Dimensions.DpToPix(183, getContext());

                Points pKhaa0 = new Points(Math.round(xKhaa0), Math.round(yKhaa0));
                lettersXYpoints.add(pKhaa0);
                Points pKhaa1 = new Points(Math.round(xKhaa1), Math.round(yKhaa1));
                lettersXYpoints.add(pKhaa1);
                Points pKhaa2 = new Points(Math.round(xKhaa2), Math.round(yKhaa2));
                lettersXYpoints.add(pKhaa2);
                Points pKhaa3 = new Points(Math.round(xKhaa3), Math.round(yKhaa3));
                lettersXYpoints.add(pKhaa3);
                break;
            case 8:
//                dal
                float xDal0 = Dimensions.DpToPix(190, getContext());
                float yDal0 = Dimensions.DpToPix(283, getContext());
                float xDal1 = Dimensions.DpToPix(146, getContext());
                float yDal1 = Dimensions.DpToPix(383, getContext());

                Points pDal0 = new Points(Math.round(xDal0), Math.round(yDal0));
                lettersXYpoints.add(pDal0);
                Points pDal1 = new Points(Math.round(xDal1), Math.round(yDal1));
                lettersXYpoints.add(pDal1);

                break;

            case 9:
                //thal
                float xThal0 = Dimensions.DpToPix(190, getContext());
                float yThal0 = Dimensions.DpToPix(283, getContext());
                float xThal1 = Dimensions.DpToPix(223, getContext());
                float yThal1 = Dimensions.DpToPix(353, getContext());
                float xThal2 = Dimensions.DpToPix(146, getContext());
                float yThal2 = Dimensions.DpToPix(383, getContext());
                float xThal3 = Dimensions.DpToPix(150, getContext());
                float yThal3 = Dimensions.DpToPix(233, getContext());

                Points pThal0 = new Points(Math.round(xThal0), Math.round(yThal0));
                lettersXYpoints.add(pThal0);
                Points pThal1 = new Points(Math.round(xThal1), Math.round(yThal1));
                lettersXYpoints.add(pThal1);
                Points pThal2 = new Points(Math.round(xThal2), Math.round(yThal2));
                lettersXYpoints.add(pThal2);
                Points pThal3 = new Points(Math.round(xThal3), Math.round(yThal3));
                lettersXYpoints.add(pThal3);

                break;
            case 10:
//                raa
                float xRaa0 = Dimensions.DpToPix(193, getContext());
                float yRaa0 = Dimensions.DpToPix(240, getContext());
                float xRaa1 = Dimensions.DpToPix(115, getContext());
                float yRaa1 = Dimensions.DpToPix(373, getContext());


                Points pRaa0 = new Points(Math.round(xRaa0), Math.round(yRaa0));
                lettersXYpoints.add(pRaa0);
                Points pRaa1 = new Points(Math.round(xRaa1), Math.round(yRaa1));
                lettersXYpoints.add(pRaa1);


                break;
//                zaa
            case 11:
                float xZaa0 = Dimensions.DpToPix(193, getContext());
                float yZaa0 = Dimensions.DpToPix(240, getContext());
                float xZaa1 = Dimensions.DpToPix(115, getContext());
                float yZaa1 = Dimensions.DpToPix(373, getContext());
                float xZaa2 = Dimensions.DpToPix(196, getContext());
                float yZaa2 = Dimensions.DpToPix(210, getContext());


                Points pZaa0 = new Points(Math.round(xZaa0), Math.round(yZaa0));
                lettersXYpoints.add(pZaa0);
                Points pZaa1 = new Points(Math.round(xZaa1), Math.round(yZaa1));
                lettersXYpoints.add(pZaa1);
                Points pZaa2 = new Points(Math.round(xZaa2), Math.round(yZaa2));
                lettersXYpoints.add(pZaa2);


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
                lettersXYpoints.add(pseen0);
                Points pseen1 = new Points(Math.round(xseen1), Math.round(yseen1));
                lettersXYpoints.add(pseen1);
                Points pseen2 = new Points(Math.round(xseen2), Math.round(yseen2));
                lettersXYpoints.add(pseen2);
                Points pseen3 = new Points(Math.round(xseen3), Math.round(yseen3));
                lettersXYpoints.add(pseen3);
                Points pseen4 = new Points(Math.round(xseen4), Math.round(yseen4));
                lettersXYpoints.add(pseen4);
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
                lettersXYpoints.add(psheen0);
                Points psheen1 = new Points(Math.round(xsheen1), Math.round(ysheen1));
                lettersXYpoints.add(psheen1);
                Points psheen2 = new Points(Math.round(xsheen2), Math.round(ysheen2));
                lettersXYpoints.add(psheen2);
                Points psheen3 = new Points(Math.round(xsheen3), Math.round(ysheen3));
                lettersXYpoints.add(psheen3);
                Points psheen4 = new Points(Math.round(xsheen4), Math.round(ysheen4));
                lettersXYpoints.add(psheen4);
                Points psheen5 = new Points(Math.round(xsheen5), Math.round(ysheen5));
                lettersXYpoints.add(psheen5);
                Points psheen6 = new Points(Math.round(xsheen6), Math.round(ysheen6));
                lettersXYpoints.add(psheen6);
                Points psheen7 = new Points(Math.round(xsheen7), Math.round(ysheen7));
                lettersXYpoints.add(psheen7);
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
                lettersXYpoints.add(psad0);
                Points psad1 = new Points(Math.round(xsad1), Math.round(ysad1));
                lettersXYpoints.add(psad1);
                Points psad2 = new Points(Math.round(xsad2), Math.round(ysad2));
                lettersXYpoints.add(psad2);
                Points psad3 = new Points(Math.round(xsad3), Math.round(ysad3));
                lettersXYpoints.add(psad3);
                Points psad4 = new Points(Math.round(xsad4), Math.round(ysad4));
                lettersXYpoints.add(psad4);
                Points psad5 = new Points(Math.round(xsad5), Math.round(ysad5));
                lettersXYpoints.add(psad5);
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
                lettersXYpoints.add(pthad0);
                Points pthad1 = new Points(Math.round(xthad1), Math.round(ythad1));
                lettersXYpoints.add(pthad1);
                Points pthad2 = new Points(Math.round(xthad2), Math.round(ythad2));
                lettersXYpoints.add(pthad2);
                Points pthad3 = new Points(Math.round(xthad3), Math.round(ythad3));
                lettersXYpoints.add(pthad3);
                Points pthad4 = new Points(Math.round(xthad4), Math.round(ythad4));
                lettersXYpoints.add(pthad4);
                Points pthad5 = new Points(Math.round(xthad5), Math.round(ythad5));
                lettersXYpoints.add(pthad5);
                Points pthad6 = new Points(Math.round(xthad6), Math.round(ythad6));
                lettersXYpoints.add(pthad6);
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
                lettersXYpoints.add(ptah0);
                Points ptah1 = new Points(Math.round(xtah1), Math.round(ytah1));
                lettersXYpoints.add(ptah1);
                Points ptah2 = new Points(Math.round(xtah2), Math.round(ytah2));
                lettersXYpoints.add(ptah2);
                Points ptah3 = new Points(Math.round(xtah3), Math.round(ytah3));
                lettersXYpoints.add(ptah3);

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
                lettersXYpoints.add(pthah0);
                Points pthah1 = new Points(Math.round(xthah1), Math.round(ythah1));
                lettersXYpoints.add(pthah1);
                Points pthah2 = new Points(Math.round(xthah2), Math.round(ythah2));
                lettersXYpoints.add(pthah2);
                Points pthah3 = new Points(Math.round(xthah3), Math.round(ythah3));
                lettersXYpoints.add(pthah3);
                Points pthah4 = new Points(Math.round(xthah4), Math.round(ythah4));
                lettersXYpoints.add(pthah4);
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
                lettersXYpoints.add(paeen0);
                Points paeen1 = new Points(Math.round(xaeen1), Math.round(yaeen1));
                lettersXYpoints.add(paeen1);
                Points paeen2 = new Points(Math.round(xaeen2), Math.round(yaeen2));
                lettersXYpoints.add(paeen2);
                Points paeen3 = new Points(Math.round(xaeen3), Math.round(yaeen3));
                lettersXYpoints.add(paeen3);
                Points paeen4 = new Points(Math.round(xaeen4), Math.round(yaeen4));
                lettersXYpoints.add(paeen4);
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
                lettersXYpoints.add(pghaen0);
                Points pghaen1 = new Points(Math.round(xghaen1), Math.round(yghaen1));
                lettersXYpoints.add(pghaen1);
                Points pghaen2 = new Points(Math.round(xghaen2), Math.round(yghaen2));
                lettersXYpoints.add(pghaen2);
                Points pghaen3 = new Points(Math.round(xghaen3), Math.round(yghaen3));
                lettersXYpoints.add(pghaen3);
                Points pghaen4 = new Points(Math.round(xghaen4), Math.round(yghaen4));
                lettersXYpoints.add(pghaen4);
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
                lettersXYpoints.add(pphaa0);
                Points pphaa1 = new Points(Math.round(xphaa1), Math.round(yphaa1));
                lettersXYpoints.add(pphaa1);
                Points pphaa2 = new Points(Math.round(xphaa2), Math.round(yphaa2));
                lettersXYpoints.add(pphaa2);
                Points pphaa3 = new Points(Math.round(xphaa3), Math.round(yphaa3));
                lettersXYpoints.add(pphaa3);
                Points pphaa4 = new Points(Math.round(xphaa4), Math.round(yphaa4));
                lettersXYpoints.add(pphaa4);
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
                lettersXYpoints.add(pkhaf0);
                Points pkhaf1 = new Points(Math.round(xkhaf1), Math.round(ykhaf1));
                lettersXYpoints.add(pkhaf1);
                Points pkhaf2 = new Points(Math.round(xkhaf2), Math.round(ykhaf2));
                lettersXYpoints.add(pkhaf2);
                Points pkhaf3 = new Points(Math.round(xkhaf3), Math.round(ykhaf3));
                lettersXYpoints.add(pkhaf3);
                Points pkhaf4 = new Points(Math.round(xkhaf4), Math.round(ykhaf4));
                lettersXYpoints.add(pkhaf4);
                Points pkhaf5 = new Points(Math.round(xkhaf5), Math.round(ykhaf5));
                lettersXYpoints.add(pkhaf5);
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
                lettersXYpoints.add(pkaf0);
                Points pkaf1 = new Points(Math.round(xkaf1), Math.round(ykaf1));
                lettersXYpoints.add(pkaf1);
                Points pkaf2 = new Points(Math.round(xkaf2), Math.round(ykaf2));
                lettersXYpoints.add(pkaf2);
                Points pkaf3 = new Points(Math.round(xkaf3), Math.round(ykaf3));
                lettersXYpoints.add(pkaf3);

                break;
            case 23:
                float xlam0 = Dimensions.DpToPix(220, getContext());
                float ylam0 = Dimensions.DpToPix(230, getContext());
                float xlam1 = Dimensions.DpToPix(155, getContext());
                float ylam1 = Dimensions.DpToPix(415, getContext());
                float xlam2 = Dimensions.DpToPix(90, getContext());
                float ylam2 = Dimensions.DpToPix(360, getContext());


                Points plam0 = new Points(Math.round(xlam0), Math.round(ylam0));
                lettersXYpoints.add(plam0);
                Points plam1 = new Points(Math.round(xlam1), Math.round(ylam1));
                lettersXYpoints.add(plam1);
                Points plam2 = new Points(Math.round(xlam2), Math.round(ylam2));
                lettersXYpoints.add(plam2);

                break;
            case 24:
                float xmeem0 = Dimensions.DpToPix(175, getContext());
                float ymeem0 = Dimensions.DpToPix(260, getContext());
                float xmeem1 = Dimensions.DpToPix(240, getContext());
                float ymeem1 = Dimensions.DpToPix(260, getContext());
                float xmeem2 = Dimensions.DpToPix(150, getContext());
                float ymeem2 = Dimensions.DpToPix(400, getContext());


                Points pmeem0 = new Points(Math.round(xmeem0), Math.round(ymeem0));
                lettersXYpoints.add(pmeem0);
                Points pmeem1 = new Points(Math.round(xmeem1), Math.round(ymeem1));
                lettersXYpoints.add(pmeem1);
                Points pmeem2 = new Points(Math.round(xmeem2), Math.round(ymeem2));
                lettersXYpoints.add(pmeem2);

                break;
            case 25:
                float xnoon0 = Dimensions.DpToPix(260, getContext());
                float ynoon0 = Dimensions.DpToPix(300, getContext());
                float xnoon1 = Dimensions.DpToPix(125, getContext());
                float ynoon1 = Dimensions.DpToPix(320, getContext());
                float xnoon2 = Dimensions.DpToPix(200, getContext());
                float ynoon2 = Dimensions.DpToPix(230, getContext());


                Points pnoon0 = new Points(Math.round(xnoon0), Math.round(ynoon0));
                lettersXYpoints.add(pnoon0);
                Points pnoon1 = new Points(Math.round(xnoon1), Math.round(ynoon1));
                lettersXYpoints.add(pnoon1);
                Points pnoon2 = new Points(Math.round(xnoon2), Math.round(ynoon2));
                lettersXYpoints.add(pnoon2);

                break;
            case 26:
                float xwao0 = Dimensions.DpToPix(220, getContext());
                float ywao0 = Dimensions.DpToPix(310, getContext());
                float xwao1 = Dimensions.DpToPix(190, getContext());
                float ywao1 = Dimensions.DpToPix(250, getContext());
                float xwao2 = Dimensions.DpToPix(160, getContext());
                float ywao2 = Dimensions.DpToPix(370, getContext());


                Points pwao0 = new Points(Math.round(xwao0), Math.round(ywao0));
                lettersXYpoints.add(pwao0);
                Points pwao1 = new Points(Math.round(xwao1), Math.round(ywao1));
                lettersXYpoints.add(pwao1);
                Points pwao2 = new Points(Math.round(xwao2), Math.round(ywao2));
                lettersXYpoints.add(pwao2);

                break;

            case 27:
                float xhaa0 = Dimensions.DpToPix(170, getContext());
                float yhaa0 = Dimensions.DpToPix(266, getContext());
                float xhaa1 = Dimensions.DpToPix(170, getContext());
                float yhaa1 = Dimensions.DpToPix(340, getContext());


                Points phaa0 = new Points(Math.round(xhaa0), Math.round(yhaa0));
                lettersXYpoints.add(phaa0);
                Points phaa1 = new Points(Math.round(xhaa1), Math.round(yhaa1));
                lettersXYpoints.add(phaa1);
                Points phaa2 = new Points(Math.round(xhaa0), Math.round(yhaa0));
                lettersXYpoints.add(phaa2);

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
                lettersXYpoints.add(pyaa0);
                Points pyaa1 = new Points(Math.round(xyaa1), Math.round(yyaa1));
                lettersXYpoints.add(pyaa1);
                Points pyaa2 = new Points(Math.round(xyaa2), Math.round(yyaa2));
                lettersXYpoints.add(pyaa2);
                Points pyaa3 = new Points(Math.round(xyaa3), Math.round(yyaa3));
                lettersXYpoints.add(pyaa3);
                Points pyaa4 = new Points(Math.round(xyaa4), Math.round(yyaa4));
                lettersXYpoints.add(pyaa4);
                Points pyaa5 = new Points(Math.round(xyaa5), Math.round(yyaa5));
                lettersXYpoints.add(pyaa5);

                break;
        }

        return lettersXYpoints;
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
//        canvas.restore();

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();

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

                    //if pixel is transparent which mean outside the letter
                    {
                        //add this path to the arraylist of paths
                        currentColor = Color.RED;
                        TouchTrace fp = new TouchTrace(currentColor, strokeWidth, mPath);
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
                float dxCompare = Math.abs(x - mxr);
                float dyCompare = Math.abs(y - myr);

                if (x < bmp.getWidth() && x > 0 && y > 0 && y < bmp.getHeight()) {
                    int pixel = bmp.getPixel(x, y);
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


                for (Points points1 : letterXYPoints) {

                    if (((points1.getX() - 30) <= x && x <= (points1.getX() + 30)) && ((points1.getY() - 30) <= y && y <= (points1.getY() + 30))) {

                        if (dxCompare > 30 || dyCompare > 30) {
                            letterPointsCounter--;
                        }
                        if (letterPointsCounter == 0) {
                            PaintViewResult paintViewResult = new PaintViewResult(getContext());
                            paintViewResult.setPaths(paths);
                            Intent n = new Intent(getContext(), BlackBoardActivity.class);
                            getContext().startActivity(n);

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            lettersCounter++;
                            viewbitmap.setCounter(lettersCounter);


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
