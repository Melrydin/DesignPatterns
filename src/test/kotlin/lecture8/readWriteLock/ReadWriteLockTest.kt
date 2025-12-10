package lecture8.readWriteLock

import org.junit.jupiter.api.Test
import kotlin.concurrent.thread
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ReadWriteLockTest {

    @Test
    fun `test that writer blocks reader (Mutual Exclusion)`() {
        println("=== TEST 1: Writer blocks Reader ===")
        val lock = ReadWriteLock()
        val eventLog = mutableListOf<String>()

        val writerThread = thread(start = true) {
            lock.writeLock.lock()
            try {
                eventLog.add("Writer acquired lock")
                println("Writer: Writing data (holding lock for 200ms)...")
                Thread.sleep(200)
                eventLog.add("Writer released lock")
                println("Writer: Done.")
            } finally {
                lock.writeLock.unlock()
            }
        }

        Thread.sleep(50)

        val readerThread = thread(start = true) {
            println("Reader: Attempting to acquire read lock...")
            lock.readLock.lock()
            try {
                eventLog.add("Reader acquired lock")
                println("Reader: Success!")
            } finally {
                lock.readLock.unlock()
            }
        }
        writerThread.join()
        readerThread.join()
        println("Event Sequence: $eventLog")

        assertEquals(3, eventLog.size)
        assertEquals("Writer acquired lock", eventLog[0])
        assertEquals("Writer released lock", eventLog[1], "Reader entered before Writer finished!")
        assertEquals("Reader acquired lock", eventLog[2])
    }

    @Test
    fun `test that multiple readers can read concurrently`() {
        println("\n=== TEST 2: Concurrent Readers ===")
        val lock = ReadWriteLock()
        val numberOfReaders = 3
        val sleepTimePerReader = 100L

        val threads = List(numberOfReaders) { id ->
            thread(start = false) {
                lock.readLock.lock()
                try {
                    println("Reader $id: Inside critical section (active readers: ${lock.readers})")
                    Thread.sleep(sleepTimePerReader)
                } finally {
                    lock.readLock.unlock()
                }
            }
        }

        val startTime = System.currentTimeMillis()

        threads.forEach { it.start() }
        threads.forEach { it.join() }

        val totalDuration = System.currentTimeMillis() - startTime
        println("Total duration: ${totalDuration}ms")

        val maxExpectedTimeForSequential = numberOfReaders * sleepTimePerReader

        assertTrue(
            totalDuration < maxExpectedTimeForSequential,
            "Readers executed sequentially instead of concurrently! Duration: $totalDuration"
        )

        assertTrue(totalDuration < (sleepTimePerReader + 150), "Performance overhead was too high.")
    }
}