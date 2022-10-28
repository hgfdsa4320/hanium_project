package com.hanium.Chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue

import com.google.firebase.ktx.Firebase
import com.hanium.R

data class ChatData(val message: String = "", val nickname: String = "")

class ChatRoomActivity : AppCompatActivity(){
    lateinit var rv : RecyclerView
    lateinit var et: EditText
    lateinit var btn: Button
    lateinit var adapter: ChatRecyclerAdapter
    private val array = ArrayList<ChatData>()
    private val db = Firebase.database
    private val myRef = db.getReference("chat").child("cindy-david")
    private val myNickname = "david"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatroom)
        rv = findViewById(R.id.chat_recyclerview)
        et = findViewById(R.id.chat_message)
        btn = findViewById(R.id.send_btn)
        val layoutManager = LinearLayoutManager(applicationContext)
        layoutManager.stackFromEnd = true
        rv.layoutManager = layoutManager

        myRef.addChildEventListener(childEventListener)
        btn.setOnClickListener(onClickListener)
        adapter = ChatRecyclerAdapter(array, myNickname)
        rv.adapter = adapter
    }
    private val childEventListener = object : ChildEventListener{
        override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
            var data = snapshot.getValue<ChatData>()
            val item = ChatData(data!!.message, data.nickname)
            adapter.addChat(item)
            rv.scrollToPosition(adapter.itemCount - 1)
        }

        override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
            TODO("Not yet implemented")
        }

        override fun onChildRemoved(snapshot: DataSnapshot) {
            TODO("Not yet implemented")
        }

        override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
            TODO("Not yet implemented")
        }

        override fun onCancelled(error: DatabaseError) {
            TODO("Not yet implemented")
        }
    }
    private val onClickListener = View.OnClickListener { view ->
        val message = et.text.toString()
        val data = ChatData(message, myNickname)
        myRef.push().setValue(data)
        et.text.clear()

    }
}