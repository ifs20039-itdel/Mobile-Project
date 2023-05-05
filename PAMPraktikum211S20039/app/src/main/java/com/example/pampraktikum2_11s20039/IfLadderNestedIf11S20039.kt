package com.example.pampraktikum2_11s20039

fun main(args: Array<String>) {
//    print("Berapakah usia mu? ")
//    var age:Int = readLine()!!.toInt()
//    if (age < 13){
//        println("Kamu seorang anak-anak")
//    }else if(age < 19){
//        println("Kamu seorang remaja")
//    }else{
//        if(age < 65){
//            println("Kamu orang dewasa")
//        }else{
//            println("Kamu orang tua")
//        }
//    }

    println("Silahkan masukkan 3 angka:")
    var x:Int = readLine()!!.toInt()
    var y:Int = readLine()!!.toInt()
    var z:Int = readLine()!!.toInt()
    if(x > y){
        if(x > z){
            println("Nilai x paling besar yaitu ${x}")
        }else{
            println("Nilai z yang paling besar yaitu ${z}")
        }
    }else{
        if(y > z){
            println("Nilai y yang paling besar yaitu ${y}")
        }else{
            println("Nilai z yang paling besar yaitu ${z}")
        }
    }
}