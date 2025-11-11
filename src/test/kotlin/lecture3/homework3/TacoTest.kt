package lecture3.homework3

import lecture3.homework3.decorator.CheeseDecorator
import lecture3.homework3.decorator.GuacamoleDecorator
import lecture3.homework3.decorator.MeetDecorator
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TacoTest {

    @Test
    fun test() {
        val tacoSize = 10
        val gramsGuacamole = 50
        val gramsCheese = 30
        val gramsMeet = 10

        val taco = GuacamoleDecorator(gramsGuacamole,
            CheeseDecorator(gramsCheese,
                MeetDecorator(gramsMeet,
                    Taco(tacoSize))))

        assertEquals(14.7, taco.calcPrice())
    }
}