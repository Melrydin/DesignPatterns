package lecture8.countingLetter

class SequenceCounterStrategy: CounterStrategy {
    override fun letterCount(content: String): Number {
        return content.asSequence()
            .filter { it.isLetter() }
            .count()
    }
}