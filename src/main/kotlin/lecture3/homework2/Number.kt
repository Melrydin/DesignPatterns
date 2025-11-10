package lecture3.homework2

class Number(private val value: Int): Expression() {
    override fun getValue(): Int = value
}