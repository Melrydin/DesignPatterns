package lecture8.countingLetter

class ForLoopCounterStrategy : CounterStrategy {
    override fun letterCount(content: String): Number {
        var counter = 0
        content.forEach { if (it.isLetter()) counter++ }
        return counter
    }
}
