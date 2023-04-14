package com.mini


// 주문 메뉴 분류
open class CafeOrderFactoryImpl : CafeOrderFactory {

    // drinkType 기본값 : ice
    override fun inputMenu(drink: String, drinkType: String, food: String?) {
        var drinkState = false
        var foodState = false

        val getDrink by lazy { getDrink(drink) }
        val getFood by lazy { getFood(food) }

        start(getDrink, getFood, drink, food)

        getDrink?.let {
            Make().drink(it,drinkType,drink)
            drinkState = true
        }

        getFood?.let{
            Make().food(it,food)
            foodState = true
        }

        success(drinkState,foodState,drink,food)
    }

    override fun getDrink(drink: String): Drink? = when (drink) {
        "에스프레소" -> Coffee.Espresso
        "아메리카노" -> Coffee.Americano
        "바닐라라떼" -> Coffee.VanillaLatte
        "카페모카" -> Coffee.CafeMocha
        "카페라떼" -> Coffee.CafeLatte
        "카라멜마끼아또" -> Coffee.CaramelMacchiato
        "복숭아아이스티" -> NonCoffee.PeachIceTea
        "레몬에이드" -> NonCoffee.LemonAde
        "체리에이드" -> NonCoffee.CherryAde
        else -> null
    }

    override fun getFood(food: String?): Food? = when(food){
        "초코케이크" -> Cake.ChocoCake
        "블루베리베이글" -> Bagel.BlueBerryBagel
        else -> null
    }

    override fun start(getDrink: Drink?, getFood: Food?, drink: String, food: String?) {
        when {
            getDrink != null && getFood != null -> println("==== [ $drink$food ] 주문 접수 ====")
            getDrink != null -> println("==== [ $drink ] 주문 접수 ====")
            getFood != null -> println("==== [ $food ] 주문 접수 ====")
        }
    }
    override fun success(drinkState: Boolean, foodState: Boolean, drink: String, food: String?) {
        when{
            drinkState && foodState -> println("==== [ $drink$food ] 주문 완료 ====")
            drinkState -> println("==== [ $drink ] 주문 완료 ====")
            foodState -> println("==== [ $food ] 주문 완료 ====")
            else -> println("==== 주문실패 ====")
        }

    }
}