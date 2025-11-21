package lecture6.parallelizingTasks

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.Random
import kotlin.time.measureTime

class CalcMeanTest {

    @Test
    fun calcMean() {
        val size = 100_000_000
        val numberOfThreads = intArrayOf(1,2,3,4,5,6,8,10,12,15,20,100,1000,2000,10_000)
        val randomNumbers = IntArray(size) {Random().nextInt(0,10)}
        var result = 0.0
        numberOfThreads.forEach { number ->
            val timer = measureTime { result = calcMean(randomNumbers, number) }
            val microseconds = timer.inWholeMicroseconds
            printResult(microseconds, number, result)
        }
    }

    fun printResult(timer: Long, numberOfThreads: Int, result: Double) {
        println("Time taken: $timer  microseconds with $numberOfThreads threads - result: $result")
    }

    @Test
    fun testCorrectness() {
        val simpleArray = IntArray(100) { 1 }
        val numberOfThreads = 4

        val result = calcMean(simpleArray, numberOfThreads)

        assertEquals(1.0, result, 0.0001, "Result: 1.0")
    }
}