package lecture3.homework5

import kotlinx.serialization.Serializable

@Serializable
data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point) = Point(x + other.x, y + other.y)
}