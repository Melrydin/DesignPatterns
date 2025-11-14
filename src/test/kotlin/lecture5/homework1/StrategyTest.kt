package lecture5.homework1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StrategyTest {

    @Test
    fun arithmeticTest() {
        val context = Context(AddOperation())
        assertEquals(6, context.executeOperation(3, 3))
        context.arithmeticOperation = MultiplyOperation()
        assertEquals(9, context.executeOperation(3, 3))
    }
}