package com.hanium.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hanium.R
import com.hanium.adapters.BuyingRecyclerViewAdapter

class BuyingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buying)
        val recyclerview: RecyclerView = findViewById(R.id.buying_recyclerview)
        val arrayList: ArrayList<Int> = arrayListOf(1,2,3,4,5,6,7,8,9,10)
        recyclerview.adapter = BuyingRecyclerViewAdapter(arrayList)
        recyclerview.layoutManager = LinearLayoutManager(this)
    }
}