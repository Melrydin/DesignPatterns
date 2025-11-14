package lecture4.homework1

import lecture4.homework1.flyweight.Point
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ObserverCanvasTest {
    private lateinit var canvas: Canvas
    private lateinit var occurrence: ShapeOccurrence

    @BeforeEach
    fun setUp(){
        canvas = Canvas()
        occurrence = ShapeOccurrence(Point(10, 10), "triangle")
        occurrence.attach(canvas)
    }

    @Test
    fun testMove(){
        assertEquals(0, canvas.updateCallCount)

        occurrence.position = Point(100, 100)

        assertEquals(1, canvas.updateCallCount)
    }

    @Test
    fun testMove_toSamePosition(){
        assertEquals(0, canvas.updateCallCount)

        occurrence.position = Point(10, 10)

        assertEquals(0, canvas.updateCallCount)
    }

    @Test
    fun testMove_detach(){
        occurrence.position = Point(100, 100)

        assertEquals(1, canvas.updateCallCount)

        occurrence.detach(canvas)
        occurrence.position = Point(10, 10)

        assertEquals(1, canvas.updateCallCount)
    }
} 