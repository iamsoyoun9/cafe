package com.mini

class MakeFoodFactoryImpl:MakeFoodFactory {
    override fun makeCake(food: Cake) {
        Make().cake(food)
    }

    override fun makeBagel(food: Bagel) {
        Make().bagel(food)
    }
}