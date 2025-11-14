package lecture5.homework2.table

enum class State { Off, Low, High }

val pressTransitions: Map<State, (Flashlight) -> Unit> = mapOf(
    State.Off to { flashlight ->
        flashlight.currentState = State.Low
        flashlight.turnON()
        },
    State.Low to { flashlight ->
        flashlight.currentState = State.Off
        flashlight.turnOFF()
    },
    State.High to { flashlight ->
        flashlight.currentState = State.Off
        flashlight.turnOFF()
    }
)

val holdTransitions: Map<State, (Flashlight) -> Unit> = mapOf(
    State.Off to { /* nothing */ },
    State.Low to { flashlight ->
        flashlight.currentState = State.High
        flashlight.increaseBrightness()
        },
    State.High to { flashlight ->
        flashlight.currentState = State.Low
        flashlight.decreaseBrightness()
    }
)
