package lecture5.homework2.`object`.States

import lecture5.homework2.`object`.Flashlight

data object StateHigh: State {
    override fun handlePress(flashlight: Flashlight) {
        flashlight.turnOFF()
        flashlight.currentState = StateOff
    }

    override fun handleHold(flashlight: Flashlight) {
        flashlight.decreaseBrightness()
        flashlight.currentState = StateLow
    }

}