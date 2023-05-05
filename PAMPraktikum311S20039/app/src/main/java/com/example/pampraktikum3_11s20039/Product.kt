package com.example.pampraktikum3_11s20039

class Product {
    var name: String? = null
    var price: Int? = null
    var stock: Int? = null

    constructor()
    constructor(name: String?, price: Int?, stock: Int?) {
        this.name = name
        this.price = price
        this.stock = stock
    }
}