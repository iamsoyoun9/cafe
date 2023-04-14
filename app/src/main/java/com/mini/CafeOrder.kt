package com.mini

class CafeOrder {
    operator fun invoke(drink: String, food: String? = null, drinkType: String = "ice") = CafeOrderFactoryImpl().inputMenu(drink = drink, drinkType = drinkType, food = food)
}