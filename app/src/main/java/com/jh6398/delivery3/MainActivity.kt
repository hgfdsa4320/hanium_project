package com.jh6398.delivery3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.json.JSONObject
import java.security.MessageDigest
import kotlin.experimental.and

class MainActivity : AppCompatActivity() {

    lateinit var idPassTv : TextView
    lateinit var loginTv : TextView
    lateinit var loginBt : Button
    lateinit var idEt : EditText
    lateinit var passEt : EditText
    var token =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        idPassTv = findViewById(R.id.idPassTv)
        loginTv = findViewById(R.id.loginTv)
        loginBt = findViewById(R.id.loginBt)
        idEt = findViewById(R.id.idEt)
        passEt = findViewById(R.id.passEt)

        loginTv.setOnClickListener(){
//            (activity as MainActivity?)!!.setFragment(MainActivity.JOIN)
        }

        loginBt.setOnClickListener(){
            val nextIntent = Intent(this, StoreActivity::class.java)
            startActivity(nextIntent)

        }

        idPassTv.setOnClickListener(){
//            (activity as MainActivity).setFragment(MainActivity.IDPASS)
        }


    }


}