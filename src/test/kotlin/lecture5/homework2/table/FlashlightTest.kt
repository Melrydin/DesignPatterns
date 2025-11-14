package lecture5.homework2.table

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FlashlightTest {

    @Test
    fun test() {
        val flashlight = Flashlight()
        assertTrue(flashlight.currentState == State.Off)
        flashlight.press()
        assertTrue(flashlight.currentState == State.Low)
        flashlight.hold()
        assertTrue(flashlight.currentState == State.High)
        flashlight.hold()
        assertTrue(flashlight.currentState == State.Low)
        flashlight.press()
        assertTrue(flashlight.currentState == State.Off)
        flashlight.press()
        assertTrue(flashlight.currentState == State.Low)
        flashlight.hold()
        assertTrue(flashlight.currentState == State.High)
        flashlight.press()
        assertTrue(flashlight.currentState == State.Off)
    }

}