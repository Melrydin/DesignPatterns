package lecture4.homework1.flyweight

import lecture4.homework1.ShapeOccurrence

class SharedPolygonShape(private val geometry: List<Point>) : Shape {

    override fun draw(occurrence: ShapeOccurrence) {
        val position = occurrence.position

        println("Draw '${occurrence.key}' on Position $position:")

        val shiftedPoints = this.geometry.map { intrinsicPoint ->
            intrinsicPoint + position
        }

        shiftedPoints.forEach { point ->
            println("  - Point by $point")
        }
    }
}