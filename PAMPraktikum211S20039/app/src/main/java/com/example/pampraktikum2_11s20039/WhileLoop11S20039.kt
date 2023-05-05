package com.example.pampraktikum2_11s20039

import kotlin.random.Random


fun main(args: Array<String>) {
//    var i = 5
//    while (i > 0){
//        println(i)
//        i--
//    }
//    var k = 1
//    var fact = 1
//    while(k < 6)
//    {
//        fact *= k // fact = fact * k
//        println("${k}! = ${fact}")
//        k++
//    }
    val targetTebakan = Random.nextInt(from = 0, until = 100)
    println("Silahkan tebak angka: ")
    while (1 == 1) // infinite loop
    {
        val tebakanUser: Int = readLine()!!.toInt()
        if (tebakanUser > targetTebakan) {
            println("Angka tebakan lebih kecil")
        } else if (tebakanUser < targetTebakan) {
            println("Angka tebakan lebih besar")
        } else {
            println("Horee kamu berhasil menebaknya")
            break
        }
    }
}



