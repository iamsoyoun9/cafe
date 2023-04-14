package com.mini

object MakeRecipeImpl : MakeRecipe {
    private lateinit var drinkType: String
    private val type by lazy { baseRecipe(drinkType) }
    private const val addCoffee = "그 위에 추출한 에스프레소를 부었습니다."

    override fun baseRecipe(drinkType: String): String {
        return if (drinkType == "ice") "얼음과" else "따뜻한"
    }

    // coffee
    override fun espressoRecipe(shot: Int) {
        Make().coffeeBean(shot)
    }

    // 오리지널 아메리카노, 헤이즐넛아메리카노...또 뭐가 있을 까?
    override fun waterBaseRecipe(drinkType: String, addItem: String?) {
        this.drinkType = drinkType
        espressoRecipe(2)
        println("컵에 $type 물을 넣었습니다.\n$addCoffee")
    }

    // 카페라떼, 카페모카, 바닐라라떼, 카라멜마끼아또
    override fun milkBaseRecipe(drink: Coffee, drinkType: String, addItem: String?) {
        this.drinkType = drinkType
        val shot = when(drink) {
            Coffee.CafeMocha -> 1
            Coffee.CafeLatte -> 2
            else -> 3 // 바닐라라떼, 카라멜마끼아또
        }
        espressoRecipe(shot)
        addItem?.let {
            val addItemSuffix = if(addItem == Vanilla().text) "를" else "을"
            println("에스프레소와 $addItem$addItemSuffix 섞었습니다.")
        }
        println("컵에 $type 우유를 넣었습니다.\n$addCoffee")
    }

    // nonCoffee
    override fun adeRecipe(addItem: String) {
        val addNonCoffee = getLiquid("탄산수")
        println("컵에 얼음과 ${addItem}청을 넣었습니다.\n$addNonCoffee")
    }

    override fun iceTeaRecipe(addItem: String) {
        val addNonCoffee = getLiquid("물")
        println("컵에 얼음과 ${addItem}농축액을 넣었습니다.\n$addNonCoffee")
    }

    // cake
    override fun cakeRecipe(cake: String) {
        println("냉장고에 ${cake}를 꺼냅니다")
        println("접시에 케이크와 포크를 세팅한다")
    }

    // bagel
    override fun bagelRecipe(bagel: String) {
        println("${bagel}을 반으로 자른다")
        println("오븐에 2분 데운다")
        println("접시에 베이글과 크림치즈를 세팅한다")
    }

    // 기타
    private fun getLiquid(liquid: String): String {
        val suffix = if (liquid == "물") "을" else "를"
        return "그 위에 $liquid$suffix 넣었습니다."
    }
}