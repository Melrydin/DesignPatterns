package lecture5.homework2.`object`.States

import lecture5.homework2.`object`.Flashlight

interface State {
    fun handlePress(flashlight : Flashlight)
    fun handleHold(flashlight : Flashlight)
}