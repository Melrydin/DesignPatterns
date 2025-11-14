package lecture5.homework2.`object`

import lecture5.homework2.`object`.States.State
import lecture5.homework2.`object`.States.StateOff

class Flashlight {

    var currentState: State
        internal set

    init {
        currentState = StateOff

        this.turnOFF()
    }

    fun press(){
        currentState.handlePress(this)
    }

    fun hold(){
        currentState.handleHold(this)
    }


    internal fun turnON(){
        println("Turning ON")
    }

    internal fun turnOFF(){
        println("Turning OFF")
    }

    internal fun increaseBrightness() {
        println("Increasing Brightness")
    }

    internal fun decreaseBrightness() {
        println("Decreasing Brightness")
    }
}