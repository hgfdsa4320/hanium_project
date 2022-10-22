package com.hanium.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.hanium.R
import com.hanium.adapters.HomeRecyclerViewAdapter
import com.hanium.adapters.HomeViewPagerAdapter

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val viewpager: ViewPager2 = findViewById(R.id.home_viewpager)
        val recyclerview: RecyclerView = findViewById(R.id.home_recyclerview)
        val arrayList: ArrayList<Int> = arrayListOf(1,2,3,4,5,6,7,8,9,10)

        recyclerview.adapter = HomeRecyclerViewAdapter(arrayList)
        recyclerview.layoutManager = GridLayoutManager(this, 2)

        viewpager.adapter = HomeViewPagerAdapter(arrayList)
        viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }
}