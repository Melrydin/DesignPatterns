package lecture4.homework1

interface Subject {
    fun attach(o: Observer)
    fun detach(o: Observer)
    fun notifyObservers(e: ChangeEvent)
} 