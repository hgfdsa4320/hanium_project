package com.hanium.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.hanium.R

class HomeRecyclerViewAdapter(val arrayList: ArrayList<Int>) : RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder>() {
    inner class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(
        R.layout.product_recyclerview_item, parent, false)){
        val img: ImageView = itemView.findViewById(R.id.product_recyclerview_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerViewAdapter.ViewHolder = ViewHolder(parent)

    override fun onBindViewHolder(holder: HomeRecyclerViewAdapter.ViewHolder, position: Int) {
        holder.img.setImageResource(R.drawable.ipad)
    }

    override fun getItemCount(): Int = arrayList.size
}