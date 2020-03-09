package com.example.veryness.working.object;

import android.graphics.Bitmap;

public class Decoration extends AnimationObject {
    Decoration(Bitmap bitmap) {
        super(bitmap);
    }

    @Override
    public boolean isMovable() {
        return false;
    }

}
