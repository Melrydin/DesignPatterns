package lecture3.homework5

class Canvas {

    private val occurrences = mutableListOf<ShapeOccurrence>()
    private val factory: ShapeFactory = ShapeFactory

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
}