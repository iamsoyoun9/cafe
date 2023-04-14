package com.mini

sealed interface Menu
sealed interface Drink : Menu
sealed interface Food : Menu

sealed interface Coffee : Drink {
    object Espresso : Coffee
    object Americano : Coffee
    object VanillaLatte : Coffee
    object CafeMocha : Coffee
    object CafeLatte : Coffee
    object CaramelMacchiato : Coffee
}

sealed interface NonCoffee : Drink {
    object CherryAde : NonCoffee
    object LemonAde : NonCoffee
    object PeachIceTea : NonCoffee
}

sealed interface Cake : Food {
    object ChocoCake : Cake
}

sealed interface Bagel : Food {
    object BlueBerryBagel : Bagel
}

sealed interface AddItem
data class Caramel(val text: String = "카라멜시럽") : AddItem
data class Choco(val text: String = "초코시럽") : AddItem
data class Vanilla(val text: String = "바닐라파우더") : AddItem
data class Cherry(val text: String = "체리") : AddItem
data class Lemon(val text: String = "레몬") : AddItem
data class Peach(val text: String = "복숭아") : AddItem
