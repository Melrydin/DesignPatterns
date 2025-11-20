package lecture5.homework1.arithmeticOpertion

import lecture5.homework1.arithmeticOperation.AddOperation
import lecture5.homework1.arithmeticOperation.Context
import lecture5.homework1.arithmeticOperation.MultiplyOperation
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class StrategyTest {

    @Test
    fun arithmeticTest() {
        val context = Context(AddOperation())
        Assertions.assertEquals(6, context.executeOperation(3, 3))
        context.arithmeticOperation = MultiplyOperation()
        Assertions.assertEquals(9, context.executeOperation(3, 3))
    }
}