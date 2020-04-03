package com.example.veryness.working.object;

public class AnimationParameters {
    //private String encoding
    private int height;
    private int width;
    private int fps;

    /*
    * Кодирока, Разрешение (, Звук?)
    *
    * FPS
    *
    *
    *
    */
    public AnimationParameters(int width, int height, int fps){
        this.height = height;
        this.width = width;
        this.fps = fps;
    }

    public AnimationParameters getAnimation(){
        return this;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getFps() {
        return fps;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setFps(int fps) {
        this.fps = fps;
    }

    //todo: Добавить поддерживаемые форматы видео для клипа, ещё что-то

}
