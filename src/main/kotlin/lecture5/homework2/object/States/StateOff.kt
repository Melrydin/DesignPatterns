package lecture5.homework2.`object`.States

import lecture5.homework2.`object`.Flashlight

data object StateOff : State {
    override fun handlePress(flashlight: Flashlight) {
        flashlight.turnON()
        flashlight.currentState = StateLow
    }

    override fun handleHold(flashlight: Flashlight) {
        // do nothing
    }

}

