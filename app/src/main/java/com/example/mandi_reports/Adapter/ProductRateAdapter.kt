package com.example.mandi_reports.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mandi_reports.R
import com.example.mandi_reports.models.Post
import com.example.mandi_reports.models.PriceDetail
import com.example.mandi_reports.models.Product
import retrofit2.Callback

class ProductRateAdapter( val datalist:List<PriceDetail>):
    RecyclerView.Adapter<ProductRateAdapter.RateHolder>() {

    class RateHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        val min:TextView=itemview.findViewById(R.id.min)
        val max:TextView=itemview.findViewById(R.id.max)
        val variety:TextView=itemview.findViewById(R.id.variety)
        val gradename:TextView=itemview.findViewById(R.id.gradename)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RateHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.products_rates,parent,false)
        return RateHolder(view)
    }

    override fun onBindViewHolder(holder: RateHolder, position: Int) {
       val data=datalist[position]
        holder.gradename.text=data.gradeName
        holder.variety.text=data.varietyName
        holder.min.text=data.minPrice.toString()
        holder.max.text=data.maxPrice.toString()
        System.out.println(datalist.size)
    }

    override fun getItemCount()=datalist.size
}