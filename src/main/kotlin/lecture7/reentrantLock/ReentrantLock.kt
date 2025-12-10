package lecture7.reentrantLock

class ReentrantLock {
    private var owner: Thread? = null
    private var lockCounter: Int = 0

    @Synchronized
    @Throws(IllegalLockStateException::class)
    fun lock(){
        val currentThread = Thread.currentThread()
        while (owner != null && owner != currentThread) {
            (this as Object).wait()
        }
        owner = currentThread
        lockCounter++
    }

    @Synchronized
    @Throws(IllegalLockStateException::class)
    fun unlock(){

        if (Thread.currentThread() != owner){
            throw IllegalLockStateException("Current thread not owner")
        }

        lockCounter--

        if (lockCounter == 0){
            owner = null
            (this as Object).notify()
        }

    }
}