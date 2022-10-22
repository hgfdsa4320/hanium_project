package com.hanium.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.hanium.R
import com.hanium.adapters.HomeRecyclerViewAdapter
import com.hanium.adapters.HomeViewPagerAdapter

class HomeActivity : AppCompatActivity() {
    lateinit var viewpager: ViewPager2
    lateinit var recyclerview: RecyclerView
    lateinit var listBtn1: Button
    lateinit var listBtn2: Button
    lateinit var listBtn3: Button
    lateinit var listBtn4: Button
    lateinit var listBtn5: Button
    lateinit var listBtn6: Button
    lateinit var listBtn7: Button
    lateinit var listBtn8: Button
    var btns = arrayOfNulls<Button>(8)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        viewpager = findViewById(R.id.home_viewpager)
        recyclerview = findViewById(R.id.home_recyclerview)
        for(i in 0..7){
            btns[i] = findViewById(resources.getIdentifier("home_list_btn${i+1}","id",packageName))
            btns[i]?.setOnClickListener(onClickListener)
        }

        val arrayList: ArrayList<Int> = arrayListOf(1,2,3,4,5,6,7,8,9,10)

        recyclerview.adapter = HomeRecyclerViewAdapter(arrayList)
        recyclerview.layoutManager = GridLayoutManager(this, 2)

        viewpager.adapter = HomeViewPagerAdapter(arrayList)
        viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    private val onClickListener = View.OnClickListener { view ->
        val intent: Intent = Intent(this, ProductListActivity::class.java)
        startActivity(intent)
    }
}