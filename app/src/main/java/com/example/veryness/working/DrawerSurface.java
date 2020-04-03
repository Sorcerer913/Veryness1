package com.example.veryness.working;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

class DrawerSurface extends SurfaceView implements SurfaceHolder.Callback {     //Pixel drawer


    private float positionX = 0;
    private float positionY = 0;
    protected float x = -1000;
    private float y = -1000;
    private float r = 50;
    private int widthPixels;
    private int heightPixels;
    private float scale = 1;
    private Bitmap bitmap;
    private Paint paint = new Paint();

    private DrawerThread drawerThread;
    final String TAG = "DrawerSurface";

    public DrawerSurface(Context context, int width, int height, Bitmap.Config bitmapConfig) {
        super(context);
        widthPixels = width;
        heightPixels = height;
        getHolder().addCallback(this);
        bitmap = Bitmap.createBitmap(widthPixels, heightPixels, bitmapConfig);   //TODO: Config will be selected in menu    //it's a color space
    }

    public DrawerSurface(Context context, Bitmap bitmap) {
        super(context);
        widthPixels = bitmap.getWidth();
        heightPixels = bitmap.getHeight();
        this.bitmap = bitmap;
        getHolder().addCallback(this);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();
        return super.onTouchEvent(event);
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        drawerThread = new DrawerSurface.DrawerThread(holder);
        drawerThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        drawerThread.requestStop();
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public DrawerThread getDrawerThread() {
        return drawerThread;
    }

    class DrawerThread extends Thread{

        private Paint paint = new Paint();
        private SurfaceHolder holder;
        boolean running;
        final String TAG = "DrawerThread";

        DrawerThread(SurfaceHolder holder){
            this.holder = holder;
            running = true;
        }

        public void requestStop() {
            running = false;
        }

        @Override
        public void run() {
            /*while (running){
            Canvas canvas = holder.lockCanvas();

                paint.setColor(Color.BLACK);

                if(canvas != null) {
                    canvas.drawColor(Color.WHITE);

                    //canvas.drawPoint(x,y, paint);
                    //draw();

                    canvas.drawCircle(x, y, r, paint);

                    //...
                }
                holder.unlockCanvasAndPost(canvas);
            }*/

        }

        /*private void draw(float x, float y, Canvas canvas, Paint paint){ ... }*/

    }

}
