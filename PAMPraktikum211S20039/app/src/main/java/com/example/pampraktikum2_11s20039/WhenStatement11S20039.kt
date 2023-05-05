package com.example.pampraktikum2_11s20039

fun main(args: Array<String>) {
    print("Pilih angka antara 1 sampai 7: ")
    var minggu:Int = readLine()!!.toInt()
    var hari:String

    when(minggu){
        1 -> hari = "Senin"
        2 -> hari = "Selasa"
        3 -> hari = "Rabu"
        4 -> hari = "Kamis"
        5 -> hari = "Jumat"
        6 -> hari = "Sabtu"
        7 -> hari = "Minggu"
        else -> hari = "Tidak ada hari dari angka yang dipilih"
    }
    println(hari)

}