package com.mini

class CoffeeBeanFactoryImpl : CoffeeBeanFactory {
    override fun getEspresso(shot: Int) {
        getCoffeeBean(shot * 30)
        setEspresso(shot)
    }

    override fun getCoffeeBean(coffeeBean: Int) {
        println("'${coffeeBean}g 커피콩' 준비완료")
    }

    override fun setEspresso(shot: Int) {
        println("'에스프레소 ${shot}샷' 추출완료")
    }
}