package com.example.veryness.working.object;

import android.graphics.Bitmap;

public abstract class AnimationObject{
    private float x;
    private float y;
    private int height;
    private int width;
    Bitmap bitmap;

    AnimationObject(Bitmap bitmap){
        x = 0;
        y = 0;
        height = bitmap.getHeight();
        width = bitmap.getWidth();
        this.bitmap = bitmap;
    }

    public abstract boolean isMovable();

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
