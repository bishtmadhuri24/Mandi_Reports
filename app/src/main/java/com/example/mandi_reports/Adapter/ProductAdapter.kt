package com.example.mandi_reports.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mandi_reports.ProductDetailsActivity
import com.example.mandi_reports.R
import com.example.mandi_reports.models.Product

class ProductAdapter(val context: Context,val dataList:List<Product>):
    RecyclerView.Adapter<ProductAdapter.DataHolder>() {
    class DataHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        val image:ImageView=itemview.findViewById(R.id.image)
        val item:TextView=itemview.findViewById(R.id.item)
        val share:TextView=itemview.findViewById(R.id.share)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.products_layout,parent,false)
        return DataHolder(view)
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
       val data=dataList[position]
        holder.item.text=data.cmdtyStdName
        Glide.with(context).load(data.picUrl).into(holder.image)

        holder.itemView.setOnClickListener(View.OnClickListener {
        Toast.makeText(context,"hello",Toast.LENGTH_LONG).show()


     val intent=Intent(context,ProductDetailsActivity::class.java)
            intent.putExtra("datapost",dataList[position])
            context.startActivity(intent)

        })

        holder.share.setOnClickListener(View.OnClickListener {
            val intent1=Intent(Intent.ACTION_SEND)
            intent1.putExtra(Intent.EXTRA_SUBJECT,"Mandi Rates Reports")
            context.startActivity(Intent.createChooser(intent1,"send to users"))
        })

    }

    override fun getItemCount()=dataList.size

}