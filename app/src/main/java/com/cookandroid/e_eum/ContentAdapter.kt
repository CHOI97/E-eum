package com.cookandroid.e_eum

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContentAdapter(private val contentList:ArrayList<Content>) : RecyclerView.Adapter<ContentAdapter.ContentViewHolder>() {

    var onItemClick : ((Content) -> Unit)? = null

    class ContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.imageView)
        val textView : TextView = itemView.findViewById(R.id.textView)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item,parent,false)
        return ContentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
       val content = contentList[position]
        holder.imageView.setImageResource(content.image)
        holder.textView.text = content.name

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(content)

        }
    }

    override fun getItemCount(): Int {
        return contentList.size
    }
}