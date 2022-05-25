package com.cookandroid.e_eum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cookandroid.e_eum.databinding.ActivityTodayResultBinding

class TodayActivity : AppCompatActivity() {
    private lateinit var viewbinding : ActivityTodayResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewbinding = ActivityTodayResultBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)

    }
}