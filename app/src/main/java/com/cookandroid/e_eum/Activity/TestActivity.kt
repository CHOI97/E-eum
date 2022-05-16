package com.cookandroid.e_eum.Activity

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import com.cookandroid.e_eum.databinding.TestLayoutBinding
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.*
import javax.security.cert.CertificateException


class TestActivity : AppCompatActivity() {
    private lateinit var viewbinding: TestLayoutBinding
    private var VIDEO_URL = "http://sldict.korean.go.kr/multimedia/multimedia_files/convert/20191029/632426/MOV000241430_700X466.mp4"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewbinding = TestLayoutBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)
        var uri: Uri = Uri.parse(VIDEO_URL)
        var  mediaController : MediaController = MediaController(this)

        setSSL()
        viewbinding.videoviewId.setVideoPath(VIDEO_URL)
        viewbinding.videoviewId.setMediaController(mediaController)
        viewbinding.videoviewId.start()

    }

    @Throws(NoSuchAlgorithmException::class, KeyManagementException::class)
    fun setSSL() {
        val trustAllCerts = arrayOf<TrustManager>(
            object : X509TrustManager {
                override fun getAcceptedIssuers(): Array<X509Certificate?>? {
                    // TODO Auto-generated method stub
                    return null
                }

                @Throws(CertificateException::class)
                override fun checkClientTrusted(
                    chain: Array<X509Certificate?>?,
                    authType: String?
                ) {
                    // TODO Auto-generated method stub
                }

                @Throws(CertificateException::class)
                override fun checkServerTrusted(
                    chain: Array<X509Certificate?>?,
                    authType: String?
                ) {
                    // TODO Auto-generated method stub
                }
            }
        )
        val sc = SSLContext.getInstance("SSL")
        sc.init(null, trustAllCerts, SecureRandom())
        HttpsURLConnection.setDefaultHostnameVerifier { hostname, session -> true }
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.socketFactory)
    }
}