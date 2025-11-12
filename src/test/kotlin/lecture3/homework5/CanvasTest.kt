package lecture3.homework5

import kotlin.test.Test

class CanvasTest {

    @Test
    fun draw() {
        val canvas = Canvas()

        canvas.addShape("triangle", Point(10, 10))
        canvas.addShape("hexagon", Point(50, 50))
        canvas.addShape("triangle", Point(100, 20))
        canvas.addShape("hexagon", Point(30, 70))
        canvas.addShape("triangle", Point(5, 40))

        canvas.drawAll()
    }
}