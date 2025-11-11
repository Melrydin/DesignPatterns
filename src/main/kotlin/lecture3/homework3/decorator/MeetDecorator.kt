package lecture3.homework3.decorator

import lecture3.homework3.AbstractTaco

class MeetDecorator(val gramsMeet: Int, override val taco: AbstractTaco): TacoDecorator(taco) {
    override fun calcPrice(): Double {
        val pricePerGram = 5.0 / 100
        val meetPrice = gramsMeet * pricePerGram
        return taco.calcPrice() + meetPrice
    }
}