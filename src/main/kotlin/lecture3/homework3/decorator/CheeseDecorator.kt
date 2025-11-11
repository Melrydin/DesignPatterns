package lecture3.homework3.decorator

import lecture3.homework3.AbstractTaco

class CheeseDecorator(val gramsCheese: Int, override val taco: AbstractTaco): TacoDecorator(taco) {
    override fun calcPrice(): Double {
        val pricePerGram = 4.0 / 100
        val cheesePrice = gramsCheese * pricePerGram
        return taco.calcPrice() + cheesePrice
    }
}