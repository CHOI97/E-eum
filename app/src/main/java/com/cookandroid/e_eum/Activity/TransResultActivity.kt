package com.cookandroid.e_eum.Activity

import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import android.media.MediaPlayer.OnPreparedListener
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import com.cookandroid.e_eum.databinding.ActivityTransResultBinding
import org.opencv.videoio.VideoCapture
import org.opencv.android.OpenCVLoader
import org.opencv.core.Mat

class TransResultActivity : AppCompatActivity() {
    lateinit var progress_Dialog: ProgressDialog
    private lateinit var viewbinding: ActivityTransResultBinding
    private lateinit var tempintent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewbinding = ActivityTransResultBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)
        var mediaController = MediaController(this)

        getProgressShow()
        tempintent = intent
        Log.d("path:",tempintent.getStringExtra("videoPath").toString())
        val VIDEO_path = tempintent.getStringExtra("videoPath").toString()
         Handler().postDelayed({
            getProgressHidden()
            viewbinding.transResultVideo.setVideoPath(VIDEO_path)
            viewbinding.transResultVideo.setMediaController(mediaController)
            viewbinding.transResultVideo.start()
            viewbinding.transResultVideo.setOnPreparedListener(OnPreparedListener { mp -> mp.setVolume(0f, 0f) })

        },4000)

    }
    fun getProgressShow(){
        try{
            var str_tittle = "Please Wait ..."
            var str_message = "잠시만 기다려주세요 ...\n번역중입니다 ..."
            var str_buttonOK = "종료"
            var str_buttonNO = "취소"

            progress_Dialog = ProgressDialog(this)
            progress_Dialog.setTitle(str_tittle) //팝업창 타이틀 지정
            progress_Dialog.setMessage(str_message) //팝업창 내용 지정
            progress_Dialog.setCancelable(false) //외부 레이아웃 클릭시도 팝업창이 사라지지않게 설정
            progress_Dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER) //프로그레스 원형 표시 설정
            progress_Dialog.setButton(DialogInterface.BUTTON_POSITIVE, str_buttonOK, DialogInterface.OnClickListener { dialog, which ->
                // TODO Auto-generated method stub
                getProgressHidden() //TODO 팝업창 비활성 처리
            })
            progress_Dialog.setButton(DialogInterface.BUTTON_NEGATIVE, str_buttonNO, DialogInterface.OnClickListener { dialog, which ->
                // TODO Auto-generated method stub
                getProgressHidden() //TODO 팝업창 비활성 처리
            })
            try {
                progress_Dialog.show()
            }
            catch (e : Exception){
                e.printStackTrace()
            }
        }
        catch(e : Exception){
            e.printStackTrace()
        }
    }
    fun getProgressHidden(){
        try {
            progress_Dialog.dismiss()
            progress_Dialog.cancel()
        }
        catch (e : Exception){
            e.printStackTrace()
        }
    }
    fun predicKSL(){

    }
}