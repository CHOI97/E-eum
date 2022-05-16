package com.cookandroid.e_eum

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DetailedAdapter(private val detailedList : ArrayList<Detailed>) :
    RecyclerView.Adapter<DetailedAdapter.DetailedViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface  onItemClickListener{

        fun onItemClickListener(position: Int)

    }

    fun setOnItemClickListener(listener: onItemClickListener){

        mListener = listener


    }



    class DetailedViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){

        val detailedImage : ImageView = itemView.findViewById(R.id.detailedImage)
        val detailedText: TextView = itemView.findViewById(R.id.detailedText)

        init{

            itemView.setOnClickListener {

                listener.onItemClickListener(adapterPosition)
            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.detailed_item,parent,false)
        return DetailedViewHolder(view,mListener)
    }

    override fun onBindViewHolder(holder: DetailedViewHolder, position: Int) {
        val currentItem = detailedList[position]
        holder.detailedImage.setImageResource(currentItem.titleImage)
        holder.detailedText.text = currentItem.heading


    }

    override fun getItemCount(): Int {

        return detailedList.size
    }


}