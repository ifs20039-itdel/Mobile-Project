package com.example.pampraktikum3_11s20039

fun main(args: Array<String>) {
    var subject = Subject("PAM", 4)
    subject.name = "Pemrograman Berbasis Mobile"
    //subject.sks = 6
    println("Matakuliah ${subject.name} dengan jumlah SKS ${subject.sks}")
}