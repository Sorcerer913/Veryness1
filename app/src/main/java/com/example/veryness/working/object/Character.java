package com.example.veryness.working.object;

import android.graphics.Bitmap;
import android.util.Pair;

import java.util.HashMap;

public class Character extends AnimationObject implements Movable{

    HashMap<Long, Pair> positions;

    Character(Bitmap bitmap) {
        super(bitmap);
    }

    @Override
    public boolean isMovable() {
        return true;
    }

    @Override
    public void moveTo(float x1, float y1) {

    }
}
