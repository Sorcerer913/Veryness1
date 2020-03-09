package com.example.veryness.working.object;

public class AnimationParameters {

    private String videoFormat;
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
    private AnimationParameters(){}

    public void setParams(
            String videoFormat,
            int height,
            int width,
            int fps
    ){
        this.videoFormat = videoFormat;
        this.height = height;
        this.width = width;
        this.fps = fps;
    }

    static AnimationParameters getInstance(){
        return new AnimationParameters();
    }

    public String getVideoFormat() {
        return videoFormat;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getFps() {
        return fps;
    }

    //todo: Добавить поддерживаемые форматы видео для клипа, ещё что-то

}
