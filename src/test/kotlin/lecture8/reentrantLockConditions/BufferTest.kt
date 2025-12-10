package lecture8.reentrantLockConditions

import org.junit.jupiter.api.Test

class BufferTest {

    @Test
    fun bufferTest(){
        val buffer: Buffer<Any> = Buffer(5)
        val producer = Producer(buffer, 100)
        val consumer = Consumer(buffer, 100)

        println("Start Simulation...")
        producer.start()
        consumer.start()

        producer.join()
        consumer.join()

        println("Finish Simulation")
    }

}