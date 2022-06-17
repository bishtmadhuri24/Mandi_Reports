package com.example.mandi_reports

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mandi_reports.Adapter.ProductRateAdapter

import com.example.mandi_reports.models.PriceDetail
import com.example.mandi_reports.models.Product


class ProductDetailsActivity : AppCompatActivity() {
    lateinit var recycler: RecyclerView
    lateinit var rateAdapter:ProductRateAdapter

    //val baseurll="https://api.gramoday.net:8082/v1/"

    val ratelist= mutableListOf<PriceDetail>()
    val ratelist1= mutableListOf<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        recycler=findViewById(R.id.recycler)
        recycler.layoutManager= LinearLayoutManager(this)
        recycler.setHasFixedSize(true)

        val Product = intent.getSerializableExtra("datapost") as? Product
        System.out.println(Product)
            if (Product != null) {
            ratelist1.addAll(listOf(Product))
        }
        for(i in ratelist1){
            ratelist.addAll(ratelist1.get(0).posts[0].priceDetails)
        }

        if (ratelist!=null && ratelist.size>0){
          rateAdapter= ProductRateAdapter(ratelist)
            recycler.adapter=rateAdapter
         }


    }

}