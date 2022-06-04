package com.cookandroid.e_eum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.cookandroid.e_eum.DBMS.AppDatabase
import com.cookandroid.e_eum.DBMS.KSL
import com.cookandroid.e_eum.databinding.ActivityDetailMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.io.File
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import javax.security.cert.CertificateException

class DetailedMainActivity : AppCompatActivity() {

    //    private  lateinit var  newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Detailed>
    private lateinit var viewbinding: ActivityDetailMainBinding
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>
    lateinit var explain: Array<String>
    lateinit var imageId2: Array<Int>
    private lateinit var tempintent: Intent
    lateinit var list_ksl: List<KSL>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = AppDatabase.getInstance(applicationContext)

        tempintent = intent
        Log.d("tempintent", tempintent.getStringExtra("content").toString())
        GlobalScope.launch {

            if (db != null) {
                list_ksl = db.kslDao().getCategory(tempintent.getStringExtra("content").toString())
                newArrayList = arrayListOf<Detailed>()
                runOnUiThread { getUserdata() }
            } else {
                Log.d("db Instance", "Failed");

            }
        }

        viewbinding = ActivityDetailMainBinding.inflate(layoutInflater)
        setContentView(viewbinding.root)


        // recylcerview item
        imageId = arrayOf(
            R.drawable.video,
        )
        // -> CTE값을 통해 받아 온 image id 는 href+origin_no
        heading = arrayOf(
            "못생기다, 추하다, 못나다. 밉다"
        )
        // -> heading 은  CTE값을 통해 전체 값으로 받아옴
        explain = arrayOf(
            getString(R.string.explain_a)
        )
        imageId2 = arrayOf(
            R.drawable.picture,
        )
        viewbinding.detailedRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
        viewbinding.detailedRecyclerView.setHasFixedSize(true)


//        getUserdata()

    }

    private fun getUserdata() {

        for (i in list_ksl.indices) {
            val detailed = Detailed(list_ksl[i].img_src, list_ksl[i].mean)
            newArrayList.add(detailed)
        }

        val adapter = DetailedAdapter(newArrayList, this)
        viewbinding.detailedRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : DetailedAdapter.onItemClickListener {
            override fun onItemClickListener(position: Int) {

                // Toast.makeText(this@DetailedMainActivity,"Click no. $position", Toast.LENGTH_SHORT).show()i

                val intent = Intent(this@DetailedMainActivity, VideoActivity::class.java)
                intent.putExtra("origin_no", list_ksl[position].origin_no)
                intent.putExtra("category", list_ksl[position].category)
                intent.putExtra("img_src", list_ksl[position].img_src)
//                intent.putExtra("explainId", explain[position])
//                intent.putExtra("imageId2", imageId2[position])
                startActivity(intent)


            }


        })


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