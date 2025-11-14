package lecture4.homework1

import lecture4.homework1.flyweight.Point
import lecture4.homework1.flyweight.ShapeFactory

class Canvas: Observer {

    private val occurrences = mutableListOf<ShapeOccurrence>()
    private val factory: ShapeFactory = ShapeFactory
    var updateCallCount = 0
        private set

    fun addShape(key: String, position: Point) {
        val occ = ShapeOccurrence(position, key)
        occurrences.add(occ)
    }

    fun drawAll() {
        println("--- Canvas is being redrawn ---")
        for (occ in occurrences) {
            val shapeToDraw = factory.getShape(occ.key)
            shapeToDraw.draw(occ)
        }
        println("------------------------------------")
    }

    override fun update(e: ChangeEvent) {
        this.updateCallCount++
        drawAll()
    }
}