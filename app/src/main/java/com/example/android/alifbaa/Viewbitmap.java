package com.example.android.alifbaa;

import android.graphics.Bitmap;

/**
 * Created by brayan pc on 12/28/2017.
 */

public  class Viewbitmap {
    private  static Bitmap mbitmap;

    public  Viewbitmap(){
        super();
    }
    public   Viewbitmap(Bitmap mbitmap){
        this.mbitmap=mbitmap;
    }

    public Bitmap getMbitmap() {
        return mbitmap;
    }

    public void setMbitmap(Bitmap mbitmap) {
        this.mbitmap = mbitmap;
    }


}
