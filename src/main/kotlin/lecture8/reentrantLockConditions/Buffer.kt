package lecture8.reentrantLockConditions

import java.util.LinkedList
import java.util.Queue
import java.util.concurrent.locks.ReentrantLock

class Buffer<T>(private val capacity: Int) {
    private val queue: Queue<T> = LinkedList()
    private val lock = ReentrantLock()
    private val fullCond = lock.newCondition()
    private val emptyCond = lock.newCondition()

    fun get(): T {
        try {
            lock.lock()
            while (queue.isEmpty()){
                println("Consumer waiting queue empty")
                fullCond.await()
            }
            val item: T = queue.poll()
            println("Consumer consume item in queue")
            emptyCond.signal()
            return item
        } finally {
            lock.unlock()
        }
    }

    fun put(item: T){
        try {
            lock.lock()
            while (queue.size == capacity){
                println("Producer waiting queue full")
                emptyCond.await()
            }
            queue.add(item)
            println("Producer put item in queue")
            fullCond.signal()
        } finally {
            lock.unlock()
        }

    }
}