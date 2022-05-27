package com.cookandroid.e_eum.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cookandroid.e_eum.databinding.ActivityDicBinding
import com.cookandroid.e_eum.databinding.ActivityDicMainBinding
import com.cookandroid.e_eum.databinding.DicMainBinding

class DicActivitiy : AppCompatActivity() {
    private lateinit var viewbinding: ActivityDicMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewbinding = ActivityDicMainBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)
    }
}