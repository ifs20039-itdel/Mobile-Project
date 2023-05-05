package com.example.pampraktikum3_11s20039

fun main(args: Array<String>) {
// ...
// ...
    var product = Product()
    println("Product: ${product.name} dengan harga ${product.price} dengan stok tersedia ${product.stock}")
    var product2 = Product("Kecap ABC", 12000, 5)
    println("Product: ${product2.name} dengan harga ${product2.price} dengan stok tersedia ${product2.stock}")
}