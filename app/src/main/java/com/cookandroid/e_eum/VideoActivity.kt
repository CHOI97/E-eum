package com.cookandroid.e_eum

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.cookandroid.e_eum.databinding.ActivityDicResultBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import javax.security.cert.CertificateException

class VideoActivity : AppCompatActivity() {
    private lateinit var viewbinding: ActivityDicResultBinding

    // origin_no , catego
    private var static_path =
        "https://sldict.korean.go.kr/front/sign/signContentsView.do?current_pos_index=0&origin_no=#switch1#&searchWay=&top_category=&category=#switch2#&detailCategory=&searchKeyword=&pageIndex=1&pageJumpIndex="
    private lateinit var VIDEO_path: String
    private lateinit var replace_path: String
    private lateinit var tempintent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewbinding = ActivityDicResultBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)
        var mediaController = MediaController(this)
        tempintent = intent
        VIDEO_path = tempintent.getStringExtra("img_src").toString()

        Log.d(
            "tempintent",
            tempintent.getStringExtra("origin_no")
                .toString() + ".........." + tempintent.getStringExtra("category").toString()
        )

        replace_path =
            static_path.replace("#switch1#", tempintent.getStringExtra("origin_no").toString())
        replace_path =
            replace_path.replace("#switch2#", tempintent.getStringExtra("category").toString())

        Log.d("replace path", replace_path)
        GlobalScope.launch{
            setSSL()
            var conn = Jsoup.connect(replace_path)
            var document: Document = conn.get()
            val parsingTitles: Elements = document.getElementsByClass("content_view_dis")
            val parsingImages: Elements = document.getElementsByClass("example")
            val parsingTitle: Element = parsingTitles.get(1)
            val parsingMean: Element = parsingTitles.get(0)
            val parsingImage: Element = parsingImages.get(0)
            val Image = parsingImage.attr("href")
            val title = parsingTitle.getElementsByTag("dd").get(0).text()
            val mean = parsingMean.getElementsByTag("dd").get(1).text()
            Log.d("test image", Image)
            Log.d("test title", title)
            Log.d("test mean", mean)
            runOnUiThread {
                viewbinding.signExplain.setText(mean)
                viewbinding.signMean.setText(title)
                Glide.with(applicationContext).load(Image).into(viewbinding.signImage)
                Log.d("test",Image);
                VIDEO_path = VIDEO_path.replace("215X161.jpg", "700X466.mp4")
                viewbinding.videoviewId.setVideoPath(VIDEO_path)
                viewbinding.videoviewId.setMediaController(mediaController)
                viewbinding.videoviewId.start()

            }
        }

//        video start code


    }

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