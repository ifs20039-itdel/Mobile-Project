package com.example.pampraktikum2_11s20039

fun main(args: Array<String>) {
    print("Silahkan memasukkan angka: ")
    var num:Int = readLine()!!.toInt()
    if(num %2 == 0){
        println("${num} adalah bilangan genap. ")
        }else{
            println("${num} adalah bilangan ganjil. ")
        }
}