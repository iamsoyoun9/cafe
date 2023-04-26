package com.mini

class Espresso(private val shot: Int) : Drink(MENU_ESPRESSO) {
    override fun make(): Espresso {
        val coffeeBean = shot * 30
        println("==== 에스프레소 추출 ==== ")
        println("원두 ${coffeeBean}g 준비 완료")
        println("에스프레소 추출 완료")
        return this
    }
}

class Americano(private val type: String) : Drink(MENU_AMERICANO) {
    override fun make(): Americano {
        Espresso(2).make()
        Type.invoke(type, WATER,"coffee")
        return this
    }
}

class VanillaLatte(private val type: String) : Drink(MENU_VANILLA_LATTE) {
    override fun make(): VanillaLatte {
            Espresso(4).make()
        println("에스프레소에 바닐라파우더 추가 후 섞기 완료")
        Type.invoke(type, MILK,"coffee")
        return this
    }
}

class CherryAde(private val type: String) : Drink(MENU_CHERRY_ADE) {
    override fun make(): CherryAde {
        Type.invoke(type,"체리청","ade")
        return this
    }
}