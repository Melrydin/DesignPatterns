package lecture6.circularBuffer

import kotlin.random.Random

class Producer(val buffer: Buffer, val itemsToProduce: Int) : Thread() {
    override fun run() {
        repeat(itemsToProduce) {
            val randomValue = Random.nextInt(100)
            buffer.put(randomValue)
        }
    }
}