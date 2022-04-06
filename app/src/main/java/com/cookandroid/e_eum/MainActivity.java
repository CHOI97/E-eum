package com.cookandroid.e_eum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Camera;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Camera camera;
    Button btn_test1;
    SurfaceView sfv_test1;
    SurfaceHolder sfv_holder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_test1 = findViewById(R.id.btn_test1);
        sfv_test1 = findViewById(R.id.sfv_test1);
    }
    class Preview extends ViewGroup implements SurfaceHolder.Callback {

        Preview(Context context) {
            super(context);

            sfv_test1 = new SurfaceView(context);
            addView(sfv_test1);
            sfv_holder = sfv_test1.getHolder();
            sfv_holder.addCallback(this);
            sfv_holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        }

        @Override
        protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

        }

        @Override
        public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {

        }

        @Override
        public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

        }

        @Override
        public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

        }
    }
}