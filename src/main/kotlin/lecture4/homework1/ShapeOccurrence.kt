package lecture4.homework1

import lecture4.homework1.flyweight.Point

class ShapeOccurrence(val initialPosition: Point, val key: String): Subject {
    val observers: MutableList<Observer> = mutableListOf()

    override fun attach(o: Observer) {
        observers.add(o)
    }

    override fun detach(o: Observer) {
        observers.remove(o)
    }

    override fun notifyObservers(e: ChangeEvent) {
        observers.forEach { it.update(e) }
    }

    var position: Point = initialPosition
        set(value) {
            if (field == value) return
            field = value
            val event = StateChangeEvent(this, value)
            notifyObservers(event)
        }
} 