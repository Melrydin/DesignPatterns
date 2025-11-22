package lecture6.circularBuffer

import kotlin.test.Test

class BufferTest {

    @Test
    fun testBuffer() {
        val buffer = Buffer(10)
        val consumer = Consumer(buffer, 20)
        val producer = Producer(buffer, 20)

        println("--- Start Buffer Test ---")
        producer.start()
        consumer.start()
        producer.join()
        consumer.join()

        println("--- Test completed: All threads are finished ---")

    }

}