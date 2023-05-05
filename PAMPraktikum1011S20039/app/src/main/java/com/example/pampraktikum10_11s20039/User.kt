package com.example.pampraktikum10_11s20039

data class User (
    val id : String,
    val name : String,
    val email : String,
    val password : String
        ) {
    constructor() : this ("", "", "", "")
}