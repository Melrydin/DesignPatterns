package lecture4.homework1.flyweight

import lecture4.homework1.ShapeOccurrence

interface Shape {
    fun draw(occurrence: ShapeOccurrence)
}