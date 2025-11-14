package lecture5.homework2.table


class Flashlight(var currentState: State = State.Off) {

    fun press() = pressTransitions[currentState]?.invoke(this)
    fun hold() = holdTransitions[currentState]?.invoke(this)

    fun turnON() = println("Turning ON")
    fun turnOFF() = println("Turning OFF")
    fun increaseBrightness() = println("Increasing Brightness")
    fun decreaseBrightness() = println("Decreasing Brightness")
}