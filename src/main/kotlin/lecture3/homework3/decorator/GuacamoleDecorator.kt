package lecture3.homework3.decorator

import lecture3.homework3.AbstractTaco

class GuacamoleDecorator(val gramsGuacamole: Int, override val taco: AbstractTaco): TacoDecorator(taco) {
    override fun calcPrice(): Double {
        val pricePerGram = 10.0 / 100
        val guacamolePrice = gramsGuacamole * pricePerGram
        return taco.calcPrice() + guacamolePrice
    }
}