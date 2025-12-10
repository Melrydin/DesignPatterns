package lecture7.diningPhilosophers

class Philosopher(
    private val name: String,
    private val group: SemaphoreGroup,
    private val leftFork: Int,
    private val rightFork: Int): Thread() {

    override fun run() {
        think()
        pickUpForks()
        eat()
        putDownForks()
    }

    private fun think(){
        println("Philosopher $name is thinking!")
    }

    private fun eat(){
        println("Philosopher $name is eating")
    }

    private fun pickUpForks(){
        println("Philosopher $name tries picking up forks!")
        group.pickup(leftFork, rightFork)
        println("Philosopher $name picked up forks!")
    }

    private fun putDownForks(){
        group.putDown(leftFork, rightFork)
        println("Philosopher $name put down forks!")
    }
}