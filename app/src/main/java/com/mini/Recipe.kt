package com.mini

open class Recipe(private val orderDrink: String, private val drinkType: String = "ice") : Drink(orderDrink) {
    override fun make():Drink = when (orderDrink) {
        MENU_ESPRESSO -> Espresso(1)
        MENU_AMERICANO -> Americano(drinkType)
        MENU_VANILLA_LATTE -> VanillaLatte(drinkType)
        MENU_CHERRY_ADE -> CherryAde(drinkType)
        else -> throw NotExistMenu("존재하지 않는 메뉴입니다.")
    }
}