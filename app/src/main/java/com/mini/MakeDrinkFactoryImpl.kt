package com.mini

// 레시피 채택
class MakeDrinkFactoryImpl : MakeDrinkFactory {

    override fun makeCoffee(drink: Coffee, drinkType: String) {
        Make().coffeeRecipe(drink,drinkType)
    }

    override fun makeNonCoffee(drink: NonCoffee) {
        Make().nonCoffeeRecipe(drink)
    }
}