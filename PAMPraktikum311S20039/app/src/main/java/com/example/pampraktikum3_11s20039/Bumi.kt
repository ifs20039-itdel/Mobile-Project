package com.example.pampraktikum3_11s20039

class Bumi(override var name: String) : Planet() {
    override fun satellite() {
        println("Bulan")
    }
}