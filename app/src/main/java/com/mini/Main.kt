package com.mini

/** 주문(String) > 제작 > 완성 */

// 주문
fun main() {
    val orderDrink = "아메리카노"
    OrderMenu().invoke(orderDrink = orderDrink, drinkType = "hot")
}

// 키오스크
class OrderMenu {
    operator fun invoke(
        orderDrink: String? = null,
        drinkType: String = "ice"
    ) {
        runCatching { Recipe(orderDrink!!, drinkType).make() }
            .onSuccess { OrderMake().getDrinkRecipe(it) }
            .onFailure { println("해당하는 메뉴가 없습니다.") }
    }
}

// 제작
class OrderMake {
    fun getDrinkRecipe(menu: Drink) {
        runCatching { menu.make() }
            .onSuccess { println("❤ 주문하신 '${it.menu}' 나왔습니다 ❤") }
            .onFailure { println("주문하신 메뉴를 만들지 못했습니다") }
    }
}