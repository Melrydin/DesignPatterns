package lecture8.reentrantLockConditions

import kotlin.random.Random

class Producer(private val buffer: Buffer<Any>, val itemsToProduce: Int) : Thread() {
    override fun run() {
        repeat(itemsToProduce) {
            val randomValue = Random.nextInt(100)
            buffer.put(randomValue)
        }
    }
}