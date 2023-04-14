package com.mini

// 손님이 주문
fun main() {
    val drink = "아메리카노"
    val food = "블루베리베이글"
    CafeOrder().invoke(drink = drink, food = food)
}