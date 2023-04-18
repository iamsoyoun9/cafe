package com.mini

class Espresso(private val shot: Int) : Drink("에스프레소") {
    override fun make(): Espresso {
        val coffeeBean = shot * 30
        println("==== 에스프레소 추출 ==== ")
        println("원두 ${coffeeBean}g 준비 완료")
        println("에스프레소 추출 완료")
        return this
    }
}

class Americano(override val menu: String, private val type: String) : Drink(menu) {
    override fun make(): Americano {
        Espresso(2).make()
        Type.invoke(type,"물","coffee")
        return this
    }
}

class VanillaLatte(override val menu: String, private val type: String) : Drink(menu) {
    override fun make(): VanillaLatte {
        Espresso(4).make()
        println("에스프레소에 바닐라파우더 추가 후 섞기 완료")
        Type.invoke(type,"우유","coffee")
        return this
    }
}

class CherryAde(override val menu: String, private val type: String) : Drink(menu) {
    override fun make(): CherryAde {
        Type.invoke(type,"체리청","ade")
        return this
    }
}