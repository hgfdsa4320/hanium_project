package com.jh6398.delivery3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuActivity : AppCompatActivity() {
    lateinit var rv : RecyclerView
    var arr: ArrayList<RoomData> = ArrayList()
    lateinit var backBt : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        backBt = findViewById(R.id.backBt)
        rv = findViewById(R.id.rv)

        var adapter : MyRvAdapter = MyRvAdapter(this,arr)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)

        arr.add(RoomData("치킨","허니콤보 드실분"))
        arr.add(RoomData("피자","피자헛 먹자"))
        arr.add(RoomData("햄버거","버거킹 세트"))
        arr.add(RoomData("중식","홍콩반점"))
        arr.add(RoomData("양식","파스타 고"))

        adapter.notifyDataSetChanged()

        backBt.setOnClickListener(){

        }


    }

    inner class MyRvAdapter(val context: Context, val arr: ArrayList<RoomData>) :
        RecyclerView.Adapter<MyRvAdapter.Holder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            val view = LayoutInflater.from(context).inflate(R.layout.room, parent, false)

            return Holder(view)
        }

        override fun getItemCount(): Int {
            return arr.size
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            holder.tv1.setText(arr.get(position).category)
            holder.tv2.setText(arr.get(position).title)



            holder.tv1.setOnClickListener {
//                Log.d("aabb", "name: " + arr.get(position).name)
//                Toast.makeText(
//                    this@StoreActivity,
//                    "name: " + arr.get(position).name,
//                    Toast.LENGTH_SHORT
//                ).show()
            }

            holder.itemView.setOnClickListener {
                Log.d("aabb", "아이템 클릭!!")
                Toast.makeText(this@MenuActivity, "아이템 클릭!!", Toast.LENGTH_SHORT).show()
            }

        }

        inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
            var tv1: TextView = itemView!!.findViewById(R.id.tv1)
            val tv2: TextView = itemView!!.findViewById(R.id.tv2)


        }
    }
}