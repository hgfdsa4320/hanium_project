package com.hanium.login.menu

import android.app.Fragment
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.hanium.R
import com.hanium.login.ItemData
import org.json.JSONObject


class SubActivity : AppCompatActivity() {
    lateinit var makeBt: Button
    lateinit var rv : RecyclerView
    lateinit var backBt : Button

    var roomList : ArrayList<ItemData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        makeBt = findViewById(R.id.makeBt)
        backBt = findViewById(R.id.backBt)
        rv= findViewById(R.id.rv)

        var token = intent.getStringExtra("token")


        getRoom()

        backBt.setOnClickListener(){
            onBackPressed()
        }



        makeBt.setOnClickListener(){
//            var newIntent : Intent = Intent(this, MakeActivity::class.java)
//            newIntent.putExtra("token",token)
//            startActivity(newIntent)

        }



    }

    fun adapterChange(){
        var adapter : MyRvAdapter = MyRvAdapter(this,roomList)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)
        adapter.notifyDataSetChanged()
    }



    fun getRoom(){
        var url = "https://wlghks1767.cafe24.com/myserver/phpfile/roomSelect.php"
        val requestQueue = Volley.newRequestQueue(this)

        val request: StringRequest = object : StringRequest(
            Request.Method.POST, url,request,fail ) {
            override fun getParams(): MutableMap<String, String> {
                val params : MutableMap<String,String> = HashMap()


                return params
            }
        }

        requestQueue.add(request)
    }

    var request = object  : Response.Listener<String> {
        override fun onResponse(response: String) {
            var jsonObject =  JSONObject(response)
            var result = jsonObject.getString("result")
            if(result=="OK") {
                var jsonArray = jsonObject.getJSONArray("room_list")
                for(i in 0 until jsonArray.length()){
                    var temp = jsonArray.getJSONObject(i)
                    var category = temp.getString("category")
                    var title = temp.getString("title")

                    var item = ItemData()
                    item.category = category
                    item.title = title
                    roomList.add(item)



                Log.d("aabb","msg: "+response)
                }
                adapterChange()



            }
            else if (result=="NK")
                Toast.makeText(this@SubActivity,"회원가입 실패", Toast.LENGTH_SHORT).show()

            Log.d("aabb","msg: "+response)

        }
    }

    var fail = object  : Response.ErrorListener {
        override fun onErrorResponse(error: VolleyError?) {
            Log.d("aabb","서버 연결 실패")
            Log.d("aabb","msg : $error")
        }
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
            holder.tv1.setText(arr.get(position).category)
            holder.tv2.setText(arr.get(position).title)

//            if(arr.get(position).isChecked == true){
//                holder.chk.isChecked = true
//            }else{
//                holder.chk.isChecked = false
//            }
//
//            holder.chk.setOnClickListener {
//                arr.get(position).isChecked = holder.chk.isChecked
//            }

//            holder.tv1.setOnClickListener {
//                Log.d("aabb", "name: " + arr.get(position).name)
//                Toast.makeText(
//                    this@SubActivity,
//                    "name: " + arr.get(position).name,
//                    Toast.LENGTH_SHORT
//                ).show()
//            }

            holder.itemView.setOnClickListener {
//                Log.d("aabb", "아이템 클릭!!")
//                Toast.makeText(this@SubActivity, "아이템 클릭!!", Toast.LENGTH_SHORT).show()
            }

        }

        inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
            var tv1: TextView = itemView!!.findViewById(R.id.tv1)
            val tv2: TextView = itemView!!.findViewById(R.id.tv2)


        }


    }
}
