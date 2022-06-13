package com.cookandroid.e_eum.Activity

//import android.content.Intent
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
//import com.cookandroid.e_eum.Activity.CameraActivity
import com.cookandroid.e_eum.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    private lateinit var viewbinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var intent: Intent
        viewbinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)
        //번역
        viewbinding.homeBtnTrans.setOnClickListener{
            //번역
            intent = Intent(this, TransActivity::class.java)
            startActivity(intent)
        }
        //사전
        viewbinding.homeBtnDic.setOnClickListener{
            intent = Intent(this, DicActivitiy::class.java)
            startActivity(intent)
        }
        //오늘
        viewbinding.homeBtnToday.setOnClickListener {
            intent = Intent(this, TodayActivity::class.java)
            startActivity(intent)
        }
    }
}