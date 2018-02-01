package com.example.android.alifbaa;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;


public class PaintView extends View {
    Bitmap bmp;
    int c = 1;

    int setImage=0;
    int counter = 2;
    ImageView imageView;
    TouchTrace fp;
    private ArrayList<Points> xypoint = lettersPoint(counter);
    int counter2 = xypoint.size();


    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }


    Letter[] letters = {
            new Letter(1, R.drawable.letter_a),
            new Letter(2, R.drawable.letter_b),
            new Letter(3, R.drawable.letter_c),
            new Letter(4, R.drawable.letter_d),
            new Letter(5, R.drawable.letter_e),
            new Letter(6, R.drawable.letter_f),
            new Letter(7, R.drawable.letter_g),
            new Letter(8, R.drawable.letter_h),
            new Letter(9, R.drawable.letter_i),
            new Letter(10, R.drawable.letter_j),
            new Letter(11, R.drawable.letter_k),
            new Letter(12, R.drawable.letter_l),
            new Letter(13, R.drawable.letter_m),
            new Letter(14, R.drawable.letter_n),
            new Letter(15, R.drawable.letter_o),
            new Letter(16, R.drawable.letter_p),
            new Letter(17, R.drawable.letter_q),
            new Letter(18, R.drawable.letter_r),
            new Letter(19, R.drawable.letter_s),
            new Letter(20, R.drawable.letter_t),
            new Letter(21, R.drawable.letter_u),
            new Letter(22, R.drawable.letter_v),
            new Letter(23, R.drawable.letter_w),
            new Letter(24, R.drawable.letter_x),
            new Letter(25, R.drawable.letter_y),
            new Letter(26, R.drawable.letter_z),
            new Letter(27, R.drawable.letter_z2),
            new Letter(28, R.drawable.letter_z3),
            new Letter(29, R.drawable.letter_z4),
            new Letter(30, R.drawable.letter_z5)};
    public static final int BRUSH_SIZE = 10;
    public static final int COLOR = Color.TRANSPARENT;
    private static final float TOUCH_TOLERANCE = 4;

    private float mX, mY,mxr,myr;

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

                Points pa = new Points(Math.round(xa0), Math.round(ya0));
                xypoints.add(pa);


                Points pa2 = new Points(Math.round(xa1), Math.round(ya1));
                xypoints.add(pa2);


                break;
            case 2:
                float x0 = Dimensions.DpToPix(60, getContext());
                float y0 = Dimensions.DpToPix(233, getContext());
                float x1 = Dimensions.DpToPix(160, getContext());
                float y1 = Dimensions.DpToPix(300, getContext());
                float x2 = Dimensions.DpToPix(276, getContext());
                float y2 = Dimensions.DpToPix(233, getContext());
                float x3 = Dimensions.DpToPix(266, getContext());
                float y3 = Dimensions.DpToPix(216, getContext());
                Points pb = new Points(Math.round(x0), Math.round(y0));
                xypoints.add(pb);


                Points pb3 = new Points(Math.round(x1), Math.round(y1));
                xypoints.add(pb3);
                Points p4 = new Points(Math.round(x2), Math.round(y2));
                xypoints.add(p4);
                Points p5 = new Points(Math.round(x2), Math.round(y2));
                xypoints.add(p5);
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
        canvas.restore();

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
        }


        //to get the bitmap which was generated from converting the image view

        if (bmp == null) {
            Log.e("bitmap", "nulllllllllllllll");
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
                        mxr= x;
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

//                        Log.e("wwwwwwwwwwwwwwwwwwwww", points1.getX()+"_"+points1.getY());
                    if (((points1.getX() - 30) <= x && x <= (points1.getX() + 30)) && ((points1.getY() - 30) <= y && y <= (points1.getY() + 30))) {

                        if (dxdraw>30||dydraw>30) {
                            counter2--;
                            Log.e("jjjjjjjjjjjjj", counter2+"" );
                        }
                        if (counter2 == 0) {
                            PaintViewResult paintViewResult = new PaintViewResult(getContext());
                            paintViewResult.setPaths(paths);
                            Intent n = new Intent(getContext(), BlackBoardActivity.class);
                            getContext().startActivity(n);
//                            launch = 1;

                            try {
                                Thread.sleep(1500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            counter++;
                            Viewbitmap viewbitmap=new Viewbitmap();
                             setImage=viewbitmap.getCounter();
                            if (setImage==1) {
                                imageView.setImageResource(letters[counter].getLetterImg());
                                bmp = getBitmapFromView(imageView);
                                Log.e("NNNNNNNNNNNNNNNN", "DONE");
                                viewbitmap.setCounter(0);
                            }
                        }

                    }
                }

                break;
            case MotionEvent.ACTION_UP:
                mxr=x;
                myr=y;
                break;

        }


//    }
        return true;
    }


    public static Bitmap getBitmapFromView(View view) {
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null)
            bgDrawable.draw(canvas);
        else
            canvas.drawColor(Color.WHITE);
        view.draw(canvas);
        return returnedBitmap;
    }
}
