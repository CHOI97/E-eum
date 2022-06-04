package com.cookandroid.e_eum

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import javax.security.cert.CertificateException

class DetailedAdapter(private val detailedList: ArrayList<Detailed>, private val context: Context) :
    RecyclerView.Adapter<DetailedAdapter.DetailedViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {

        fun onItemClickListener(position: Int)

    }

    fun setOnItemClickListener(listener: onItemClickListener) {

        mListener = listener


    }


    class DetailedViewHolder(itemView: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {

        val detailedImage: ImageView = itemView.findViewById(R.id.detailedImage)
        val detailedText: TextView = itemView.findViewById(R.id.detailedText)

        init {

            itemView.setOnClickListener {

                listener.onItemClickListener(adapterPosition)
            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailedViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.detailed_item, parent, false)
        return DetailedViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: DetailedViewHolder, position: Int) {
        val currentItem = detailedList[position]
        setSSL()
        Glide.with(context).load(currentItem.titleImage).into(holder.detailedImage)
        holder.detailedText.text = currentItem.heading
        Log.d("image resource", currentItem.titleImage)
    }

    override fun getItemCount(): Int {
        return detailedList.size
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