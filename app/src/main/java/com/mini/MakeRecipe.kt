package com.mini

sealed interface MakeRecipe {
    fun baseRecipe(drinkType: String): String
    fun espressoRecipe(shot: Int)
    fun waterBaseRecipe(drinkType: String, addItem: String? = null)
    fun milkBaseRecipe(drink: Coffee, drinkType: String, addItem: String? = null)

    fun adeRecipe(addItem: String)
    fun iceTeaRecipe(addItem: String)

    fun cakeRecipe(cake: String)
    fun bagelRecipe(bagel: String)
}