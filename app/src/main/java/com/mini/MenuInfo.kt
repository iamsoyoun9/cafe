package com.mini
class NotExistMenu(message: String) : Exception(message)

object Type {
    operator fun invoke(type: String, liquid: String, menu: String) {
        val suffix = if (liquid == "우유") "를" else "을"
        val typeResult = when (type) {
            "ice" -> "유리컵에 얼음과"
            else -> "머그컵에 따뜻한"
        }
        println("==== 세팅 ====\n$typeResult $liquid$suffix 넣었습니다.")
        when (menu) {
            "coffee" -> println("그 위에 추출한 에스프레소를 넣었습니다.")
            "ade" -> println("그 다음 탄산수를 넣었습니다")
            else -> println("")
        }
    }
}

interface Menu
abstract class Drink(val menu: String) : Menu {
    abstract fun make(): Drink
    companion object {
        const val MENU_ESPRESSO = "에스프레소"
        const val MENU_AMERICANO = "아메리카노"
        const val MENU_VANILLA_LATTE ="바닐라라떼"
        const val MENU_CHERRY_ADE = "체리에이드"

        const val WATER = "물"
        const val SPARKLING_WATER = "탄산수"
        const val MILK = "우유"

        const val VANILLA_POWDER = "바닐라파우더"
    }
}

sealed class State<out R>{
    data class Success<out T>(val data:T) : State<T>()
    data class Error(val exception:Exception):State<Nothing>()
}
