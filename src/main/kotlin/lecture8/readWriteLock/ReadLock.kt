package lecture8.readWriteLock

class ReadLock(private val host: ReadWriteLock) {

    fun lock(){
        synchronized(host){
            while (host.writers > 0 || host.writeRequests > 0){
                (host as Object).wait()
            }
            host.readers++
        }
    }

    fun unlock(){
        synchronized(host){
            host.readers--
            if (host.readers == 0) {
                (host as Object).notifyAll()
            }
        }
    }
}