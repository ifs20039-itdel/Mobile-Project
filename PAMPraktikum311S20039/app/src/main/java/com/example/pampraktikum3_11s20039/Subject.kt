package com.example.pampraktikum3_11s20039

class Subject {
    var name:String? = null
    var sks:Int? = null
        private set
    constructor(name:String, sks:Int){
        this.name = name
        this.sks = sks
    }
}