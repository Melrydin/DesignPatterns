package lecture10.countdownLatch

import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.atomics.ExperimentalAtomicApi
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@OptIn(ExperimentalAtomicApi::class)
class CountdownLatch(initialCount: Int) {

    private val count = AtomicInteger(initialCount)

    private val waiters = ConcurrentLinkedDeque<Continuation<Unit>>()

    suspend fun await(){
        if (count.get() <= 0) return

        suspendCoroutine<Unit> {
            continuation ->

            if (count.get() > 0) {
                waiters.add(continuation)
            } else {
                continuation.resume(Unit)
            }
        }
    }

    fun countDown(){
        val newCount = count.decrementAndGet()

        if (newCount == 0){
            var waiter = waiters.poll()

            while (waiter != null){
                waiter.resume(Unit)
                waiter = waiters.poll()
            }
        }
    }
}