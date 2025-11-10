package lecture3.homework2

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ExpressionTest {

    @Test
    fun testExpression() {
        val expression = Difference(Sum(
            NegativeExpression(Number(2)),
            Number(5)), Number(2))

        val actualResult = expression.getValue()

        assertEquals(1, actualResult)
    }
}