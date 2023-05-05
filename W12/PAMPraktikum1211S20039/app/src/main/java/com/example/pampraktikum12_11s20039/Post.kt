package com.example.pampraktikum12_11s20039

import com.google.gson.annotations.SerializedName

data class Post (
    val userId : Int,
    val id : Int,
    val title : String, @SerializedName("body")
    val subtitle : String
)