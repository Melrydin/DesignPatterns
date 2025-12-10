package lecture7.reentrantLock

import org.junit.jupiter.api.Assertions.*
import kotlin.concurrent.thread
import kotlin.test.Test

class ReentrantLockTest {

    @Test
    fun reentrantLockTest(){
        val lock = ReentrantLock()
        lock.lock()
        try {
            lock.lock()
        } catch (e: Exception) {
            fail("Should not crash or freeze on the second lock")
        }
        lock.unlock()
        lock.unlock()
        assertThrows(IllegalLockStateException::class.java) {
            lock.unlock()
        }
    }

    @Test
    fun `test unlock throws exception if not owner`() {
        val lock = ReentrantLock()

        assertThrows(IllegalLockStateException::class.java) {
            lock.unlock()
        }

        lock.lock()

        val t = thread {
            assertThrows(IllegalLockStateException::class.java) {
                lock.unlock()
            }
        }
        t.join()
    }

    @Test
    fun `test mutual exclusion`() {
        val lock = ReentrantLock()
        val eventLog = mutableListOf<String>()

        val t1 = thread(start = false) {
            lock.lock()
            eventLog.add("T1: locked")
            Thread.sleep(100)
            eventLog.add("T1: working")
            lock.unlock()
            eventLog.add("T1: unlocked")
        }

        val t2 = thread(start = false) {
            Thread.sleep(20)
            lock.lock()
            eventLog.add("T2: locked")
            lock.unlock()
        }

        t1.start()
        t2.start()

        t1.join()
        t2.join()

        val t1UnlockIndex = eventLog.indexOf("T1: unlocked")
        val t2LockIndex = eventLog.indexOf("T2: locked")

        println(eventLog)

        assertTrue(t1UnlockIndex < t2LockIndex, "T2 hat den Lock bekommen, bevor T1 fertig war!")
    }

}