package lecture8.countingLetter

class StreamCounterStrategy : CounterStrategy {
    override fun letterCount(content: String): Number {
        return content.chars()
            .parallel()
            .filter { Character.isLetter(it) }
            .count()
    }
}