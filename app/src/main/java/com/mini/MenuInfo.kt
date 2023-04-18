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
abstract class Drink(open val menu: String) : Menu {
    abstract fun make():Drink
}