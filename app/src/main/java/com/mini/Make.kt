package com.mini

class Make {
    fun drink(drink: Drink, drinkType: String, drinkString: String) {
        when (drink) {
            is Coffee -> MakeDrinkFactoryImpl().makeCoffee(drink, drinkType)
            is NonCoffee -> MakeDrinkFactoryImpl().makeNonCoffee(drink)
        }
        println("❤ 주문하신 ${drinkString}가 완성되었습니다 ❤")
    }

    fun food(food: Food, foodString: String?) {
        when (food) {
            is Cake -> MakeFoodFactoryImpl().makeCake(food)
            is Bagel -> MakeFoodFactoryImpl().makeBagel(food)
        }
        val foodSuffix = if(food is Cake) "가" else "이"
        println("❤ 주문하신 $foodString$foodSuffix 완성되었습니다 ❤")
    }

    fun coffeeBean(shot:Int) = CoffeeBeanFactoryImpl().getEspresso(shot)

    fun coffeeRecipe(drink: Coffee, drinkType: String) {
        when (drink) {
            is Coffee.Espresso -> MakeRecipeImpl.espressoRecipe(1)
            is Coffee.Americano -> MakeRecipeImpl.waterBaseRecipe(drinkType)
            is Coffee.CafeLatte -> MakeRecipeImpl.milkBaseRecipe(drink, drinkType)
            is Coffee.CafeMocha -> MakeRecipeImpl.milkBaseRecipe(drink, drinkType, Choco().text)
            is Coffee.VanillaLatte -> MakeRecipeImpl.milkBaseRecipe(drink, drinkType, Vanilla().text)
            is Coffee.CaramelMacchiato -> MakeRecipeImpl.milkBaseRecipe(drink, drinkType, Caramel().text)
        }
    }
    fun nonCoffeeRecipe(drink: NonCoffee) {
        when (drink) {
            is NonCoffee.LemonAde -> MakeRecipeImpl.adeRecipe(Lemon().text)
            is NonCoffee.CherryAde -> MakeRecipeImpl.adeRecipe(Cherry().text)
            is NonCoffee.PeachIceTea -> MakeRecipeImpl.iceTeaRecipe(Peach().text)
        }
    }
    fun cake(food: Cake) {
        when(food){
            is Cake.ChocoCake -> MakeRecipeImpl.cakeRecipe("초코케이크")
        }
    }
    fun bagel(food: Bagel) {
        when(food){
            is Bagel.BlueBerryBagel -> MakeRecipeImpl.bagelRecipe("블루베리베이글")
        }
    }
}