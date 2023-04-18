package com.mini

open class Recipe(private val orderDrink: String, private val drinkType: String = "ice") : Drink(orderDrink) {
    override fun make():Drink = when (orderDrink) {
        "에스프레소" -> Espresso(1)
        "아메리카노" -> Americano(orderDrink, drinkType)
        "바닐라라떼" -> VanillaLatte(orderDrink, drinkType)
        "체리에이드" -> CherryAde(orderDrink, drinkType)
        else -> throw NotExistMenu("존재하지 않는 메뉴입니다.")
    }
}