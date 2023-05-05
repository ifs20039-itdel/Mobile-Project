package com.example.pampraktikum3_11s20039

class Antlantis (override var name: String, override var temperature: String) : Place(), Environment{
    override fun location():String {
        return "Samudra Antlantik"
    }
}
