package com.cookandroid.e_eum

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class VideoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val videoText : TextView = findViewById(R.id.title_image)
        val videoText2 : TextView = findViewById(R.id.title_explain)
        val videoText3 : TextView = findViewById(R.id.explain)
        val videoText4 : TextView = findViewById(R.id.title_name)
        val videoText5 : TextView = findViewById(R.id.name)
        val videoImage1 : ImageView = findViewById(R.id.Image)
        val videoImage : ImageView = findViewById(R.id.videoImage)


        val bundle: Bundle?= intent.extras
        val heading = bundle!!.getString("heading")
        val imageId = bundle.getInt("imageId")
        val imageId2 = bundle.getInt("imageId2")
        val news = bundle.getString("explainId")

        videoText3.text = news
        videoImage.setImageResource(imageId)
        videoText5.text = heading
        videoImage1.setImageResource(imageId2)





    }
}