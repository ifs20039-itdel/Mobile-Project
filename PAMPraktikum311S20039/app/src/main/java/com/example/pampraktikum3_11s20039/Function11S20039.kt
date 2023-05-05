package com.example.pampraktikum3_11s20039

fun main(args: Array<String>) {
    print("Masukkan nilai 1: ")
    var num1:Int = readLine()!!.toInt()
    print("Masukkan nilai 2: ")
    var num2:Int = readLine()!!.toInt()
    var result:Int = minValue(num1, num2)
    print("Nilai terendah: ")
    printVal(result)
}
fun printVal(num:Int){
    println("${num}")
}
fun minValue(num1:Int, num2:Int): Int{
    return if(num1 > num2) num2 else num1
}