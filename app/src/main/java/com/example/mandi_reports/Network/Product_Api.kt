package com.example.mandi_reports.Network

import com.example.mandi_reports.models.DataProducts
import com.example.mandi_reports.models.Product
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET

interface Product_Api {
    @GET("user/bySlug?profileSlug=mmtradingco")
    fun getProduct(): retrofit2.Call<DataProducts>
}