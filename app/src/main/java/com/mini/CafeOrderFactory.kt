package com.mini

interface CafeOrderFactory {
    fun inputMenu(drink: String, drinkType: String, food: String? = null)
    fun getDrink(drink: String): Drink?
    fun getFood(food: String?): Food?
    fun start(getDrink: Drink?, getFood: Food?, drink: String, food: String?)
    fun success(drinkState: Boolean, foodState: Boolean, drink: String, food: String?)
}