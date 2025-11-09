package lecture3.homework1

import lecture3.homework1.legacy.LegacyPoint
import lecture3.homework1.legacy.LegacyTriangle
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TriangleAdapterTest() {

    lateinit var adapter: TriangleAdapter

    @BeforeEach
    fun setup(){
        val point1 = LegacyPoint(0.0, 0.0)
        val point2 = LegacyPoint(1.0, 0.0)
        val point3 = LegacyPoint(0.5, 1.0)
        val legacyTriangle = LegacyTriangle(point1, point2, point3)

        adapter = TriangleAdapter(legacyTriangle)
    }

    @Test
    fun testGetXPos(){
        assertEquals(0.0, adapter.getXPos())
    }

    @Test
    fun testGetYPos(){
        assertEquals(0.0, adapter.getYPos())
    }

    @Test
    fun testSetXPos(){
        adapter.setXPos(5.0)

        assertEquals(5.0, adapter.triangle.point1.x)
        assertEquals(6.0, adapter.triangle.point2.x)
        assertEquals(5.5, adapter.triangle.point3.x)

        assertEquals(0.0, adapter.triangle.point1.y)
        assertEquals(0.0, adapter.triangle.point2.y)
        assertEquals(1.0, adapter.triangle.point3.y)

    }

    @Test
    fun testSetYPos(){
        adapter.setYPos(5.0)

        assertEquals(5.0, adapter.triangle.point1.y)
        assertEquals(5.0, adapter.triangle.point2.y)
        assertEquals(6.0, adapter.triangle.point3.y)

        assertEquals(0.0, adapter.triangle.point1.x)
        assertEquals(1.0, adapter.triangle.point2.x)
        assertEquals(0.5, adapter.triangle.point3.x)
    }

    @Test
    fun testArea(){
        assertEquals(0.5, adapter.area())
    }

    @Test
    fun testScale(){
        adapter.scale(2.0)

        assertEquals(2.0, adapter.area())

        assertEquals(0.0, adapter.triangle.point1.x)
        assertEquals(2.0, adapter.triangle.point2.x)
        assertEquals(1.0, adapter.triangle.point3.x)
        assertEquals(2.0, adapter.triangle.point3.y)
    }
}