package lecture7.diningPhilosophers

class SemaphoreGroup(numberOfMembers: Int) {
    private val values: Array<Boolean> = Array(numberOfMembers) {false}

    init {
        require(numberOfMembers > 1) {"Value must be > 1"}
    }

    @Synchronized
    @Throws(InterruptedException::class)
    fun pickup(leftFork: Int, rightFork: Int){
        while (values[leftFork] || values[rightFork]){
            (this as Object).wait()
        }
        values[leftFork] = true
        values[rightFork] = true
    }

    @Synchronized
    @Throws(InterruptedException::class)
    fun putDown(leftFork: Int, rightFork: Int) {
        values[leftFork] = false
        values[rightFork] = false
        (this as Object).notifyAll()
    }
}