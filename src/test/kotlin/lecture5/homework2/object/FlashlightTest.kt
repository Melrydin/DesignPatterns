package lecture5.homework2.`object`

import lecture5.homework2.`object`.States.StateHigh
import lecture5.homework2.`object`.States.StateLow
import lecture5.homework2.`object`.States.StateOff
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FlashlightTest {
    @Test
    fun test() {
        val f = Flashlight()
        assertTrue(f.currentState is StateOff)
        f.press()
        assertTrue(f.currentState is StateLow)
        f.hold()
        assertTrue(f.currentState is StateHigh)
        f.hold()
        assertTrue(f.currentState is StateLow)
        f.hold()
        assertTrue(f.currentState is StateHigh)
        f.press()
        assertTrue(f.currentState is StateOff)
        f.press()
        assertTrue(f.currentState is StateLow)
        f.press()
        assertTrue(f.currentState is StateOff)
        f.hold()
    }

}