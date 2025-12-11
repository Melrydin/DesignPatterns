package lecture8.countingLetter

interface CounterStrategy {
    fun letterCount(content: String): Number
}