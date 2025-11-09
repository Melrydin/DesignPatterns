package lecture3.homework1

import lecture3.homework1.legacy.LegacyTriangle
import kotlin.math.abs

class TriangleAdapter(val triangle: LegacyTriangle): Shape2D, IScalable, IShiftable {
    override fun getXPos(): Double {
        return triangle.point1.x
    }

    override fun getYPos(): Double {
        return triangle.point1.y
    }

    override fun setXPos(x: Double) {
        val deltaX = x - getXPos()
        shift(deltaX, 0.0)
    }

    override fun setYPos(y: Double) {
        val deltaY = y - getYPos()
        shift(0.0, deltaY)
    }

    override fun area(): Double {
        val point1 = triangle.point1
        val point2 = triangle.point2
        val point3 = triangle.point3
        return 0.5* abs(point1.x*(point2.y - point3.y) + point2.x*(point3.y - point1.y) + point3.x*(point1.y - point2.y))
    }

    override fun scale(factor: Double) {
        val vec12x = triangle.point2.x - triangle.point1.x
        val vec12y = triangle.point2.y - triangle.point1.y

        val vec13x = triangle.point3.x - triangle.point1.x
        val vec13y = triangle.point3.y - triangle.point1.y

        triangle.point2.x = triangle.point1.x + (vec12x * factor)
        triangle.point2.y = triangle.point1.y + (vec12y * factor)

        triangle.point3.x = triangle.point1.x + (vec13x * factor)
        triangle.point3.y = triangle.point1.y + (vec13y * factor)
    }

    override fun shift(x: Double, y: Double) {
        triangle.point1.x += x
        triangle.point1.y += y

        triangle.point2.x += x
        triangle.point2.y += y

        triangle.point3.x += x
        triangle.point3.y += y
    }
}