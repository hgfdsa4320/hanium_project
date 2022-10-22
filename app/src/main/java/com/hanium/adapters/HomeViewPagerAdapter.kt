package com.hanium.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.hanium.R

class HomeViewPagerAdapter(var arrayList: ArrayList<Int>) :
    RecyclerView.Adapter<HomeViewPagerAdapter.ViewHolder>() {
    inner class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.viewpager_item, parent, false)){
        val img: ImageView = itemView.findViewById(R.id.viewpager_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent)


    override fun onBindViewHolder(holder: HomeViewPagerAdapter.ViewHolder, position: Int) {
        holder.img.setImageResource(R.drawable.ipad)
    }

    override fun getItemCount(): Int = arrayList.size
}