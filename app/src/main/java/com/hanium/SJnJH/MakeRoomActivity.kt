package com.hanium.SJnJH

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hanium.databinding.ActivityMakeRoomBinding

class MakeRoomActivity : AppCompatActivity() {
    val binding by lazy{ ActivityMakeRoomBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}