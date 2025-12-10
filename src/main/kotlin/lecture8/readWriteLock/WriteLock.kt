package lecture8.readWriteLock

class WriteLock(private val host: ReadWriteLock) {

    fun lock() {
        synchronized(host){
            host.writeRequests++
            try {
                while (host.readers > 0 || host.writers > 0){
                    (host as Object).wait()
                }
            }finally {
                host.writeRequests--
            }
            host.writers++
        }
    }

    @Synchronized
    fun unlock() {
        synchronized(host){
            host.writers--
            (host as Object).notifyAll()
        }
    }
}