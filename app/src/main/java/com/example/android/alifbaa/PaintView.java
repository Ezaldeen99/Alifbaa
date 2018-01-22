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

/**
 * Created by brayan pc on 12/27/2017.
 */

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
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
        paths.clear();
        invalidate();

    }

//    public void create(DisplayMetrics metrics) throws IOException, ClassNotFoundException {
//
//        int height = metrics.heightPixels;
//        int width = metrics.widthPixels;
////this will retrive last path to display it on the black screen
//        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
//        cCanvas = new Canvas(mBitmap);
//        cCanvas.drawColor(Color.BLACK);
//
//        for (TouchTrace fb : paths) {
//            mPaint.setColor(fb.color);
//            mPaint.setStrokeWidth(fb.strokeWidth);
//
//            cCanvas.drawPath(fp.path, mPaint);
//        }
////        bmp = LetterTrackingActivity.viewbitmap.getMbitmap();
////        Object b=fon(bmp);
////        cCanvas.drawPath( mPaint);
//        invalidate();
//
//    }

//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
////ths method have to be overrided to draw
//        mCanvas.drawColor(Color.TRANSPARENT);
////the background of the paintView is set here which is transparent
//
//        for (TouchTrace Tt : paths) {
//            mPaint.setColor(Tt.color);
//            mPaint.setStrokeWidth(Tt.strokeWidth);
//            mCanvas.drawPath(Tt.path, mPaint);
////display the path with colors chosen on canvas
//        }
////        canvas.drawPath(mPath, mPaint);
////        canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);
////        canvas.restore();
//
//        Paint painttt = new Paint();
//        painttt.setStyle(Paint.Style.STROKE);
//        painttt.setColor(Color.WHITE);
//        painttt.setStrokeWidth(10);
////
//        Path pathttt = new Path();
////
////
////        pathttt.moveTo(170, 650);
////       float scale=LetterTrackingActivity.viewbitmap.getScreensize();
////        DisplayMetrics metrics = LetterTrackingActivity.viewbitmap.getScreensize();
////
////        int heights = metrics.heightPixels;
////        int widths = metrics.widthPixels;
////
////
////        bmp = LetterTrackingActivity.viewbitmap.getMbitmap();
////
////        int[][] cc = arrayFromBitmap(bmp);
//////        int[][] bb = null;
////        Path mPath2 = new Path();
////        TouchTrace fp2;
////        for (int i = 0; i < cc.length; i++) {
////            for (int j = 0; j < cc.length; j++) {
////                if (cc[i][j] == -31379873) {
//////                    bb[i][j] = cc[i][j];
////                    fp2 = new TouchTrace(currentColor, strokeWidth, mPath2);
////                    paths.add(fp2);
////                }
////            }
////
////        }
////        canvas.drawPath(mPath2, mPaint);
//
//
////        int pixelll = bmp.getPixel(170, 700);
////        String hexColor = String.format("#%06X", (0xFFFFFF & pixelll));
////        Log.e("cccccccccccccc", hexColor);
////
////        int hexpixel = getResources().getColor(R.color.letters_color);
////        String hex = String.format("#%06X", (0xFFFFFF & hexpixel));
////        Log.e("kkkkkkkkkkkkk", hex);
////
////
//////        pathttt.moveTo(  ( 170 - (widths / 2)) * - bmp.getWidth()  , (250 - (heights/ 2)) * - bmp.getHeight() );
//////        pathttt.offset(  (  (widths / 2))   , ( (heights/ 2))  );
////
////
//////        pathttt.moveTo((widths / 2)   , (heights/ 2));
////
//////        if (hexColor.equals(hex)) {
//        float x0 = Dimensions.convertPixelsToDp(1000, getContext());
//        float y0 = Dimensions.convertPixelsToDp(1200, getContext());
//        float x1 = Dimensions.convertPixelsToDp(1000, getContext());
//        float y1 = Dimensions.convertPixelsToDp(1200, getContext());
//        float x2 = Dimensions.convertPixelsToDp(1400, getContext());
//        float y2 = Dimensions.convertPixelsToDp(1400, getContext());
//        float x3 = Dimensions.convertPixelsToDp(1450, getContext());
//        float y3 = Dimensions.convertPixelsToDp(1200, getContext());
//        pathttt.moveTo(x0, y0);
////        pathttt.moveTo(170, 250);
//
//        pathttt.cubicTo(x1, y1, x2, y2, x3, y3);
////        pathttt.cubicTo(215, 870, 850, 870, 810, 650);
//////
//////        pathttt.moveTo(480, 1100);
////        pathttt.lineTo(x3, y3);
////
////
//////        pathttt.lineTo(0, 0);
////
//////        }
//        canvas.drawPath(pathttt, painttt);
//
//    }






//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        mCanvas.drawColor(Color.TRANSPARENT);
//
//        for (TouchTrace Tt : paths) {
//            mPaint.setColor(Tt.color);
//            mPaint.setStrokeWidth(Tt.strokeWidth);
//            mCanvas.drawPath(Tt.path, mPaint);
//        }
////        canvas.drawPath(mPath, mPaint);
//        canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);
//        canvas.restore();
//        float mX2=0, mY2=0;
//
//        Paint paint2 = new Paint();
//        paint2.setStyle(Paint.Style.STROKE);
//        paint2.setColor(Color.BLACK);
//        paint2.setStrokeWidth(10);
//
//        bmp = LetterTrackingActivity.viewbitmap.getMbitmap();
//
//
//        int[][] cc = arrayFromBitmap(bmp);
//        Path mPath2 = new Path();
//        TouchTrace fp2 = new TouchTrace(currentColor, strokeWidth, mPath2);;
//        paths.add(fp2);
//        int c=0;
//        for (int i = 0; i < cc.length; i++) {
//            for (int j = 0; j < cc.length; j++) {
//                if (cc[i][j] == -31379873) {
//                    if (c==0) {
//                        mPath2.moveTo(i, j);
//                        mX2 = i;
//                        mY2 = j;
//                        c++;
//                    }
//                    else
//                    {
//                        mPath2.quadTo(mX2, mY2, (i + mX2) / 2, (j + mY2) / 2);
//                        mX2 = i;
//                        mY2 = j;
//                    }
//                }
//            }
//
//        }
//        canvas.drawPath(mPath2, paint2);
//
//
//
//    }















    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mCanvas.drawColor(Color.TRANSPARENT);

        for (TouchTrace Tt : paths) {
            mPaint.setColor(Tt.color);
            mPaint.setStrokeWidth(Tt.strokeWidth);
            mCanvas.drawPath(Tt.path, mPaint);
        }
//        canvas.drawPath(mPath, mPaint);
//        canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);
//        canvas.restore();

        Paint painttt = new Paint();
        painttt.setStyle(Paint.Style.STROKE);
        painttt.setColor(Color.WHITE);
        painttt.setStrokeWidth(10);
        Path pathttt = new Path();





//        float x0 = Dimensions.convertPixelsToDp(1000, getContext());
//        float y0 = Dimensions.convertPixelsToDp(1200, getContext());
//        float x1 = Dimensions.convertPixelsToDp(1000, getContext());
//        float y1 = Dimensions.convertPixelsToDp(1200, getContext());
//        float x2 = Dimensions.convertPixelsToDp(1400, getContext());
//        float y2 = Dimensions.convertPixelsToDp(1400, getContext());
//        float x3 = Dimensions.convertPixelsToDp(1450, getContext());
//        float y3 = Dimensions.convertPixelsToDp(1200, getContext());

//        pathttt.moveTo(x0, y0);
//        pathttt.moveTo(215, 870);


//        pathttt.quadTo(x1, y1, x2, y2);
        pathttt.quadTo( 180,700,480,900);

        pathttt.quadTo( 480,900,830, 700);

//        pathttt.cubicTo(215, 870, 850, 870, 810, 650);
////        pathttt.moveTo(480, 1100);
//        pathttt.lineTo(x3, y3);

////        pathttt.lineTo(0, 0);

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
                        Log.e("bbbbbbbbbbbfjortorut", pixel + "");

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


//    public Object fon(Bitmap m) throws IOException, ClassNotFoundException {
//        int[] pixels;
//        int height = m.getHeight();
//        int width = m.getWidth();
//
//        pixels = new int[height * width];
//        int j = 0;
//        m.getPixels(pixels, 0, width, 1, 1, width - 1, height - 1);
//        int[] pixels2=null;
//        for (int i = 0; i < pixels.length; i++) {
//            if (pixels[i] == -31379873) {
//                pixels2[j] = pixels[i];
//
//
//                j++;
//            }
//
//        }
//        Log.e("nnnnnnnnnnnnnn",""+pixels2);
//        byte[] c = integersToBytes(pixels2);
//        ByteArrayInputStream in = new ByteArrayInputStream(c);
//        ObjectInputStream is = new ObjectInputStream(in);
//        return is.readObject();
//
//
//    }
//
//
//    byte[] integersToBytes(int[] values) throws IOException {
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        DataOutputStream dos = new DataOutputStream(baos);
//        for (int i = 0; i < values.length; ++i) {
//            dos.writeInt(values[i]);
//        }
//
//        return baos.toByteArray();
//    }


    public static int[][] arrayFromBitmap(Bitmap source) {
        int width = source.getWidth();
        int height = source.getHeight();
        int[][] result = new int[width][height];
        int[] pixels = new int[width * height];
        source.getPixels(pixels, 0, width, 0, 0, width, height);
        int pixelsIndex = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                result[i][j] = pixels[pixelsIndex];
                pixelsIndex++;
            }
        }
        return result;
    }
}


