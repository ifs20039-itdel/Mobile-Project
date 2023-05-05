package com.example.pampraktikum2_11s20039

fun main(args: Array<String>) {
    var a:Int = 6
    var b:Int = 5
    var c:Int = 7
    var result:Boolean

    result = (a > b) && (b > c)
    println("Dengan operator &&: ${result}")
    println()
    result = (a > b) || (b > c)
    println("Dengan operator ||: ${result}")
}