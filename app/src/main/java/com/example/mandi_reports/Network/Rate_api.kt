package com.example.mandi_reports.Network

import com.example.mandi_reports.models.Post
import retrofit2.Call
import retrofit2.http.GET

interface Rate_api {
    @GET("user/bySlug?profileSlug=mmtradingco")
    fun getRate():retrofit2.Call<Post>
}