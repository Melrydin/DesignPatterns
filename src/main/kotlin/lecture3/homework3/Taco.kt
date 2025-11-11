package lecture3.homework3

class Taco(val size: Int): AbstractTaco() {
    override fun calcPrice(): Double {
        val tacoSizePrice = 0.04*(size*size) + 4
        return tacoSizePrice
    }
}
