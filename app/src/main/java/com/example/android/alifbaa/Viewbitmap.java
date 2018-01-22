package com.example.android.alifbaa;

import android.graphics.Bitmap;
import android.util.DisplayMetrics;

/**
 * Created by brayan pc on 12/28/2017.
 */

public class Viewbitmap {
    private Bitmap mbitmap;


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
