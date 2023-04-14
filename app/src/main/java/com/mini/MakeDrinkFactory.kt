package com.mini

interface MakeDrinkFactory {
    fun makeCoffee(drink: Coffee, drinkType: String)
    fun makeNonCoffee(drink: NonCoffee)
}