package com.cookandroid.e_eum

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cookandroid.e_eum.databinding.HomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var viewbinding: HomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewbinding = HomeBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)
        viewbinding.btnTestCamera.setOnClickListener {
            var intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
        }
    }
}