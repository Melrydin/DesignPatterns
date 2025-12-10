package lecture8.reentrantLockConditions

class Consumer(private val buffer: Buffer<Any>, val itemsToConsume: Int) : Thread() {
    override fun run() {
        repeat(itemsToConsume) {
            buffer.get()
        }
    }
}