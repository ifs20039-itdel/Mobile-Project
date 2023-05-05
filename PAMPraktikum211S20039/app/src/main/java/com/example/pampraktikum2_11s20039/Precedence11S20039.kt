package com.example.pampraktikum2_11s20039

fun main(args: Array<String>) {
    var result:Int

    result = 4 + 5 * 2
    println("result: ${result}")

    println()
    result = (4 + 5) * 2
    println("result: ${result}")

    var x:Int = 5
    var y:Int = 6
    println()
    result = --y * ++x
    println("result: ${result}")
}