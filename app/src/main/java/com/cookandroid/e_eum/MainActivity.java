package com.cookandroid.e_eum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Camera;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Camera camera;
    Button btn_test_start,btn_test_end;
    SurfaceView sfv_test1;
    SurfaceHolder sfv_holder;
    boolean previewing = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_test_start = findViewById(R.id.btn_test_start);
        btn_test_end = findViewById(R.id.btn_test_end);
        sfv_test1 = findViewById(R.id.sfv_test1);

        getWindow().setFormat(PixelFormat.UNKNOWN);
        sfv_test1 = (SurfaceView)findViewById(R.id.sfv_test1);
        sfv_holder = sfv_test1.getHolder();
//        sfv_holder.addCallback(this);
        sfv_holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }
}