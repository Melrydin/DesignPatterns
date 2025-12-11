package lecture8.countingLetter

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.system.measureNanoTime

class LetterCounterTest {

    private val mobyDick = "/home/arch/Documents/IntelliJ/DesignPatterns/src/test/resources/mobyDick.txt"
    private val expectedCount1: Number = 970446L

    private val shakespeare = "/home/arch/Documents/IntelliJ/DesignPatterns/src/test/resources/shakespeare.txt"
    private val expectedCount2: Number = 4072577L

    @Test
    fun `compare all strategies correctness`() {
        val strategies = listOf(
            ForLoopCounterStrategy(),
            SequenceCounterStrategy(),
            StreamCounterStrategy()
        )
        val counter = LetterCounter(ForLoopCounterStrategy())
        for (strategy in strategies) {
            counter.comparatorStrategy = strategy
            val strategyName = strategy::class.simpleName

            println("--- Testing $strategyName ---")

            val result1 = counter.countLetters(mobyDick)
            assertEquals(expectedCount1, result1, "$strategyName failed on mobyDick.txt")
            println("mobyDick.txt Result: $result1 (Correct)")

            val result2 = counter.countLetters(shakespeare)
            assertEquals(expectedCount2, result2, "$strategyName failed on shakespeare.txt")
            println("shakespeare.txt Result: $result2 (Correct)")
        }
    }

    @Test
    fun `benchmark performance comparison`() {
        println("\n=== PERFORMANCE BENCHMARK ===")

        val bigFile = "big_benchmark.txt"
        val bigContent = "abc ABC 123 ".repeat(10_000_000)
        File(bigFile).writeText(bigContent)

        val expected = 60_000_000L

        val strategies = listOf(
            ForLoopCounterStrategy(),
            SequenceCounterStrategy(),
            StreamCounterStrategy()
        )
        val counter = LetterCounter(ForLoopCounterStrategy())
        strategies.forEach { strategy ->
            counter.comparatorStrategy = strategy

            val time = measureNanoTime {
                val result = counter.countLetters(bigFile)
                assertEquals(expected, result)
            }

            println("${strategy::class.simpleName?.padEnd(25)} : ${time / 1_000_000} ms")
        }

        File(bigFile).delete()
    }
}