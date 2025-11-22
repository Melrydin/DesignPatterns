package lecture6.circularBuffer

class Buffer(private val capacity: Int) {
    private var data: IntArray = IntArray(capacity)
    private var writeIndex: Int = 0
    private var readIndex: Int = 0
    private var count: Int = 0

    @Synchronized
    fun put(data: Int) {
        while (count == capacity){
            println("Writing data full")
            (this as Object).wait()
        }
        this.data[writeIndex] = data
        println("Writing data[$writeIndex] = $data")
        writeIndex = (writeIndex + 1) % capacity
        count++
        (this as Object).notifyAll()
    }

    @Synchronized
    fun get(): Int {
        while (count == 0){
            println("Waiting data empty")
            (this as Object).wait()
        }
        val item = data[readIndex]
        println("Reading data[$readIndex] = $item")
        readIndex = (readIndex + 1) % capacity
        count--
        (this as Object).notifyAll()
        return item
    }
}