package lecture7.diningPhilosophers

import org.junit.jupiter.api.Test

class PhilosopherTest {

    @Test
    fun run() {
        val n = 5
        val semaphoreGroup = SemaphoreGroup(n)
        val philosopher = Array(n) { i ->
            Philosopher(
                "P$i",
                semaphoreGroup,
                i,
                (i + 1) % n
            )
        }

        println("--- Starting all Philosophers ---")
        philosopher.forEach { it.start() }

        Thread.sleep(1_000)

        println("--- Stoping all Philosophers ---")

        philosopher.forEach { it.interrupt() }
        philosopher.forEach { it.join() }

        print("--- All Philosophers stopped ---")
    }
}