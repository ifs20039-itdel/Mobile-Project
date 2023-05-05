package com.example.pampraktikum12_11s20039

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitAPI {
    @GET("/posts")
    fun getAllPosts() : Call<List<Post>>
}