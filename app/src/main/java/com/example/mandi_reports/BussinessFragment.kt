package com.example.mandi_reports

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mandi_reports.Adapter.ProductAdapter
import com.example.mandi_reports.Network.Product_Api
import com.example.mandi_reports.models.DataProducts
import com.example.mandi_reports.models.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BussinessFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BussinessFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
lateinit var productAadapter:ProductAdapter
lateinit var recyclerView: RecyclerView
val baseurl="https://api.gramoday.net:8082/v1/"
    val listproduct= mutableListOf<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_bussiness, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView=view.findViewById(R.id.recyclerview)
        recyclerView.layoutManager=LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)
        getProductDetails()
    }

    private fun getProductDetails() {
        val retro= Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val call=retro.create(Product_Api::class.java).getProduct()
        call.enqueue(object : Callback<DataProducts?> {
            override fun onResponse(call: Call<DataProducts?>, response: Response<DataProducts?>) {
                val body=response.body()
                listproduct.addAll(body!!.products)
                productAadapter= context?.let { ProductAdapter(it,listproduct) }!!
                recyclerView.adapter=productAadapter
            }

            override fun onFailure(call: Call<DataProducts?>, t: Throwable) {
                Log.d("main","error")
            }
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BussinessFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BussinessFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}