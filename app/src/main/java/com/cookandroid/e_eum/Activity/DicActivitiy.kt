package com.cookandroid.e_eum.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cookandroid.e_eum.databinding.DicMainBinding

class DicActivitiy : AppCompatActivity() {
    private lateinit var viewbinding: DicMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewbinding = DicMainBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)
    }
}