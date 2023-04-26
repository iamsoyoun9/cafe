package com.mini

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

//
//[코루틴을 가루로 드셔보셨습니까?]
//
// 커피를 제작하면서 동시에 주문을 받아보자.
//
//⁃	각 메뉴의 제작 과정에 적절한 delay 설정
//⁃	음료 머신이 작동중(suspend) 일 땐 동시에 주문을 받을 수 있다.
//⁃	주문은 Queue에 쌓여야하며, 순차대로 음료가 제작되어야함.

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