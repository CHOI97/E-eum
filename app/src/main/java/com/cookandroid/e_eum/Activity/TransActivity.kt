package com.cookandroid.e_eum.Activity

import android.app.Activity
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.cookandroid.e_eum.URIPathHelper
import com.cookandroid.e_eum.databinding.ActivityTransMainBinding
import java.io.*


class TransActivity: AppCompatActivity()  {
    private lateinit var viewbinding: ActivityTransMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var intent2: Intent
        viewbinding = ActivityTransMainBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)
        //촬영
        viewbinding.btnTransCamera.setOnClickListener{
            intent2 = Intent(this,CameraActivity::class.java)
            startActivity(intent2)
        }
        viewbinding.btnTransFile.setOnClickListener{
            openGalleryForVideo()
        }

    }
    private fun openGalleryForVideo() {
        val intent = Intent()
        intent.type = "video/*"
        intent.action = Intent.ACTION_PICK
        startActivityForResult(Intent.createChooser(intent, "Select Video"),10)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 10) {
            if (data?.data != null) {
                val uriPathHelper = URIPathHelper()
                val videoFullPath = uriPathHelper.getPath(this, data?.data!!)
                if (videoFullPath != null) {
                    playVideoInDevicePlayer(videoFullPath)
                }
            }
        }
    }
    fun playVideoInDevicePlayer(videoPath: String) {
        val intent = Intent(this, TransResultActivity::class.java)
        intent.putExtra("videoPath",videoPath)
        startActivity(intent)
    }
}