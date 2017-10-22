package com.example.it.mytestapplication;

import android.content.Context;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

public class CameraView extends SurfaceView implements SurfaceHolder.Callback {

    private Camera camera;
    private SurfaceHolder holder;  //サーフェイスホルダーオブジェクト

    public CameraView(Context context) {
        super(context);

        //サーフェイスホルダーの取得とコールバック通知先の指定
        holder = getHolder;
        holder.addCallback(this);

        //SurfaceViewの種別をプッシュバッファーに変更します
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

    }

    public void surfaceCreated(SurfaceHolder holder){
        //カメラを呼び出す
        camera = Camera.open();
        //表示先のサーフェイスホルダーを指定
        setPreviewDisplay(SurfaceHolder holder);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

}
