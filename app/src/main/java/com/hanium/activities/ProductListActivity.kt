package com.hanium.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hanium.R
import com.hanium.adapters.HomeRecyclerViewAdapter

class ProductListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        val recyclerview: RecyclerView = findViewById(R.id.product_list_recyclerview)
        val arrayList: ArrayList<Int> = arrayListOf(1,2,3,4,5,6,7,8,9,10)

        recyclerview.adapter = HomeRecyclerViewAdapter(arrayList)
        recyclerview.layoutManager = GridLayoutManager(this, 2)
    }

}