package com.cookandroid.e_eum.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.cookandroid.e_eum.ContentMainActivity
//import com.cookandroid.e_eum.DBMS.AppDatabase
import com.cookandroid.e_eum.databinding.ActivityDicMainBinding

class DicActivitiy : AppCompatActivity() {
    private lateinit var viewbinding: ActivityDicMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewbinding = ActivityDicMainBinding.inflate(layoutInflater)

        setContentView(viewbinding.root)
        var intent = Intent(this ,ContentMainActivity::class.java)
        viewbinding.btnDicDaily.setOnClickListener {
            intent.putExtra("category","CTE")
            startActivity(intent)
        }

        viewbinding.btnDicSpecial.setOnClickListener {
            intent.putExtra("category","SPE")
            startActivity(intent)
        }
    }
}