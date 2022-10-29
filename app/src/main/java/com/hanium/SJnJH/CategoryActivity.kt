package com.hanium.SJnJH

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.hanium.R


class CategoryActivity : AppCompatActivity() {
    lateinit var chickenBt : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        chickenBt = findViewById(R.id.chickenBt)

        chickenBt.setOnClickListener(){
            val nextIntent = Intent(this, DeliveryStoresActivity::class.java)
            startActivity(nextIntent)
        }

    }
}