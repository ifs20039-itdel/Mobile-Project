package com.example.pamprak039

data class MyImage(
    val id : String = "",
    val label : String = "",
    val url : String = "",
    val imageName : String = ""
){
    constructor() : this ("", "", "", "")
}
