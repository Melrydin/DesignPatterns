package lecture6.circularBuffer

class Consumer(val buffer: Buffer, val itemsToConsume: Int) : Thread() {
    override fun run() {
        repeat(itemsToConsume) {
            buffer.get()
        }
    }
}