package com.example.haniumproject

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.haniumproject.databinding.ItemStoresBinding


class PizzaFragment : Fragment() {

    lateinit var recyclerView : RecyclerView
    val pizzaStoreArray = mutableListOf<StoreInform>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        var rootView = inflater.inflate(R.layout.fragment_pizza, container, false)
        for (i in 1..100){
            val name = "도미노$i"
            val minPrice = i*100
            val deliveryTip = i*30
            pizzaStoreArray.add(StoreInform(context?.let {
                AppCompatResources.getDrawable(
                    it,
                    R.drawable.asd
                )
            }!!,name, minPrice,deliveryTip))
        }
        recyclerView = rootView.findViewById(R.id.pizzaRecyclerView!!)as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = PizzaListAdapter(requireContext(),pizzaStoreArray)

        return rootView
    }
}


class PizzaListAdapter(val context: Context, val pizzaStoreArray: List<StoreInform>) : RecyclerView.Adapter<PizzaListAdapter.Holder>() {

    class Holder(val binding: ItemStoresBinding) : RecyclerView.ViewHolder(binding.root){
        fun setItem(store: StoreInform) {
            with(binding) {
                imageView.setImageDrawable(store.image)
                storeName.text = store.name
                minPrice.text = "${store.minPrice}원"
                deliveryTip.text = "${store.deliveryTip}원"
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaListAdapter.Holder {
        val binding = ItemStoresBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PizzaListAdapter.Holder(binding)
    }
    override fun getItemCount() = pizzaStoreArray.size

    override fun onBindViewHolder(holder: Holder, position: Int) = holder.setItem(pizzaStoreArray.get(position))

}
