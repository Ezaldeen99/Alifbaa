package com.example.android.alifbaa;

import android.graphics.Path;


public class TouchTrace {
    public int color;
    public int strokeWidth;
    public Path path;

    public TouchTrace(int color, int strokeWidth, Path path) {
        this.color = color;
        this.strokeWidth = strokeWidth;
        this.path = path;
    }

}
