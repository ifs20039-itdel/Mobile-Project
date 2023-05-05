package com.example.pampraktikum3_11s20039

fun main(args: Array<String>) {
    var myCar = Car()
    myCar.name = "Ferrari"
    myCar.model = 2021
    var myCar2 = Car()
    myCar2.name = "Mercedes"
    myCar2.model = 2010
    println("Mobil ke-1: ${myCar.name} model ${myCar.model}")
    println("Mobil ke-2: ${myCar2.name} model ${myCar2.model}")
}