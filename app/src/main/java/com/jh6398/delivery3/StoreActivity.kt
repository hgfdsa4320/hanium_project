package com.jh6398.delivery3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StoreActivity : AppCompatActivity() {
    lateinit var rv : RecyclerView
    var arr: ArrayList<ItemData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        rv = findViewById(R.id.rv)

        var adapter : MyRvAdapter = MyRvAdapter(this,arr)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)

        val dividerItemDecoration =
            DividerItemDecoration(rv.context, LinearLayoutManager(this).orientation)

        rv.addItemDecoration(dividerItemDecoration)


        arr.add(ItemData(R.drawable.hoeny,"허니콤보","20,000원"))
        arr.add(ItemData(R.drawable.hoeny,"레드콤보","22,000원"))
        arr.add(ItemData(R.drawable.hoeny,"오리지널","23,000원"))

        adapter.notifyDataSetChanged()


    }


    inner class MyRvAdapter(val context: Context, val arr: ArrayList<ItemData>) :
        RecyclerView.Adapter<MyRvAdapter.Holder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            val view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)

            return Holder(view)
        }

        override fun getItemCount(): Int {
            return arr.size
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            holder.iv.setImageResource(arr.get(position).menuImg)
            holder.tv1.setText(arr.get(position).menu)
            holder.tv2.setText(arr.get(position).price)



            holder.iv.setOnClickListener {
//                Log.d("aabb", "name: " + arr.get(position).name)
//                Toast.makeText(
//                    this@StoreActivity,
//                    "name: " + arr.get(position).name,
//                    Toast.LENGTH_SHORT
//                ).show()
            }

            holder.itemView.setOnClickListener {
                Log.d("aabb", "아이템 클릭!!")
                Toast.makeText(this@StoreActivity, "아이템 클릭!!", Toast.LENGTH_SHORT).show()
            }

        }

        inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
            var iv: ImageView = itemView!!.findViewById(R.id.iv)
            val tv1: TextView = itemView!!.findViewById(R.id.tv1)
            val tv2: TextView = itemView!!.findViewById(R.id.tv2)

        }
    }


}