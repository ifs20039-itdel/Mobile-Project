package com.example.pampraktikum2_11s20039

fun main(args: Array<String>) {
    print("Siapa nama kamu?")
    var name:String? = readLine()
    print("Berapa usia kamu? ")
    var age:Int = readLine()!!.toInt()

    println("Nama kamu: ${name} dan usia kamu: ${age}")
}