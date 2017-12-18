package com.example.android.alifbaa;

/**
 * Created by azozs on 12/15/2017.
 */

import android.graphics.Paint;
import android.graphics.Path;

public class PathWithPaint {
    private Path path;

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    private Paint mPaint;

    public Paint getmPaint() {
        return mPaint;
    }

    public void setmPaint(Paint mPaint) {
        this.mPaint = mPaint;
    }
}