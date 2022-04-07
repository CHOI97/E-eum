package com.cookandroid.e_eum

import androidx.appcompat.app.AppCompatActivity
import android.view.SurfaceView
import android.view.SurfaceHolder
import android.os.Bundle
import com.cookandroid.e_eum.R
import android.graphics.PixelFormat
import android.hardware.Camera
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var camera: Camera? = null
    var btn_test_start: Button? = null
    var btn_test_end: Button? = null
    var sfv_test1: SurfaceView? = null
    var sfv_holder: SurfaceHolder? = null
    var previewing = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_test_start = findViewById(R.id.btn_test_start)
        btn_test_end = findViewById(R.id.btn_test_end)
        sfv_test1 = findViewById(R.id.sfv_test1)
        window.setFormat(PixelFormat.UNKNOWN)
        sfv_test1 = findViewById<View>(R.id.sfv_test1) as SurfaceView
        sfv_holder = sfv_test1!!.holder
    }
}