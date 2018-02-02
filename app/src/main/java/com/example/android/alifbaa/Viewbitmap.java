package com.example.android.alifbaa;

import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.util.Log;

import java.util.ArrayList;



public class Viewbitmap {
    private Bitmap mbitmap;
    private ArrayList mPath;

    public int getCounter() {
        Log.e("ssssssssssssssssssg", counter+"");
        return counter;

    }

    public void setCounter(int counter) {
        this.counter = counter;
        Log.e("ssssssssssssssssssset", counter+"");
    }

    private int counter;

    public ArrayList getmPath() {
        return mPath;
    }

    public void setmPath(ArrayList mPath) {
        this.mPath = mPath;

    }

    public Viewbitmap() {
        super();
    }

    public Bitmap getMbitmap() {
        return mbitmap;
    }

    public void setMbitmap(Bitmap mbitmap) {
        this.mbitmap = mbitmap;
    }


    }

