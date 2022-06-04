package com.cookandroid.e_eum.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.MediaController
import com.bumptech.glide.Glide
import com.cookandroid.e_eum.DBMS.AppDatabase
import com.cookandroid.e_eum.DBMS.KSL
import com.cookandroid.e_eum.databinding.ActivityTodayResultBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import java.lang.NullPointerException
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import javax.security.cert.CertificateException

class TodayActivity : AppCompatActivity() {
    private lateinit var viewbinding : ActivityTodayResultBinding
    private lateinit var today_ksl: KSL

    val static_num = 14000;
    private var static_path = "https://sldict.korean.go.kr/front/sign/signContentsView.do?current_pos_index=0&origin_no=#switch1#&searchWay=&top_category=&category=#switch2#&detailCategory=&searchKeyword=&pageIndex=1&pageJumpIndex="
    private lateinit var replace_path: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewbinding = ActivityTodayResultBinding.inflate(layoutInflater)
        val db = AppDatabase.getInstance(applicationContext)
        setContentView(viewbinding.root)
        today_number()
        var mediaController = MediaController(this)
        GlobalScope.launch  {
            if (db != null) {
                today_ksl = db.kslDao().getRandomKSL(today_number()%static_num)
                replace_path =
                    static_path.replace("#switch1#", today_ksl.origin_no)
                replace_path =
                    replace_path.replace("#switch2#", today_ksl.category)
                setSSL()
                var conn = Jsoup.connect(replace_path)
                var document: Document = conn.get()
                val parsingTitles: Elements = document.getElementsByClass("content_view_dis")
                val parsingTitle: Element = parsingTitles.get(1)
                val parsingMean: Element = parsingTitles.get(0)
                val title = parsingTitle.getElementsByTag("dd").get(0).text()
                val mean = parsingMean.getElementsByTag("dd").get(1).text()
                Log.d("test title", title)
                Log.d("test mean", mean)
                runOnUiThread{
                    viewbinding.todatExplain.setText(mean)
                    viewbinding.todayMaen.text = title
                    today_ksl.img_src = today_ksl.img_src.replace("215X161.jpg", "700X466.mp4")
                    viewbinding.todayVideo.setVideoPath(today_ksl.img_src)
                    viewbinding.todayVideo.setMediaController(mediaController)
                    viewbinding.todayVideo.start()
                }
            }
        }

    }
    fun today_number(): Int {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
        val formatted = current.format(formatter)
        Log.d("today: ",formatted)
        return formatted.toInt()
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