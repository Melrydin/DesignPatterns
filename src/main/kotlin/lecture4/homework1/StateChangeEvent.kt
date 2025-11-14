package lecture4.homework1

import lecture4.homework1.flyweight.Point

data class StateChangeEvent(val source: ShapeOccurrence, val newState: Point) : ChangeEvent