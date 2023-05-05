package com.example.pampraktikum3_11s20039

class CardChild : Card() {
    fun originalShape() {
        super.shape()
    }
    override fun shape() {
        println("Lingkaran")
    }
}