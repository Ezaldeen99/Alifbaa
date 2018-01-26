package com.example.android.alifbaa;

import android.graphics.Bitmap;
import android.util.DisplayMetrics;

import java.util.ArrayList;



public class Viewbitmap {
    private Bitmap mbitmap;
    private ArrayList mPath;

    public ArrayList getmPath() {
        return mPath;
    }

    public void setmPath(ArrayList mPath) {
        this.mPath = mPath;
    }

    private DisplayMetrics screensize;

    public Viewbitmap() {
        super();
    }

    public Viewbitmap(Bitmap mbitmap) {
        this.mbitmap = mbitmap;
    }

    public Bitmap getMbitmap() {
        return mbitmap;
    }

    public void setMbitmap(Bitmap mbitmap) {
        this.mbitmap = mbitmap;
    }

    public DisplayMetrics getScreensize() {
        return screensize;
    }

    public void setScreensize(DisplayMetrics screensize) {
        this.screensize = screensize;
    }

}
