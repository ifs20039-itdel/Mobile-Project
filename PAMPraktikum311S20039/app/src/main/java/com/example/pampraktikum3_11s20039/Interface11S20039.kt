package com.example.pampraktikum3_11s20039

fun main(args: Array<String>) {
    var atlantis = Antlantis("Atlantis", "Dingin")
    println("Lokasi ${atlantis.name} terletak di ${atlantis.location()} memiliki suhu yang ${atlantis.temperature}")
}