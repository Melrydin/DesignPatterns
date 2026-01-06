package lecture10.countdownLatch

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
class EternalStarCommandTest {

    private val STANDBY = "STANDBY"
    private val ACTIVE = "PHOENIX PROTOCOL ACTIVE"

    @Test
    fun countDownLatchTest() = runTest {
        val parametersNeeded = 3
        val phoenixLatch = CountdownLatch(parametersNeeded)

        var novaStatus = STANDBY

        println("TEST: Simulation started. Nova is waiting...")

        launch {
            phoenixLatch.await()
            novaStatus = ACTIVE
        }

        advanceUntilIdle()
        assertEquals(STANDBY, novaStatus, "Nova must not start too early!")

        launch {
            println("TEST: Reactor stable...")
            phoenixLatch.countDown()
        }

        launch {
            println("TEST: Weapons online...")
            phoenixLatch.countDown()
        }

        advanceUntilIdle()
        assertEquals(STANDBY, novaStatus, "Nova triggered too early (only 2/3 ready)!")

        launch {
            println("TEST: Admiral authorizes...")
            phoenixLatch.countDown()
        }

        advanceUntilIdle()
        assertEquals(ACTIVE, novaStatus, "The Phoenix Protocol was not activated!")
        println("TEST: Success! $novaStatus")
    }
}