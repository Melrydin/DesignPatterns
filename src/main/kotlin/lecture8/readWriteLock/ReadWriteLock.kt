package lecture8.readWriteLock

class ReadWriteLock {

    var readers = 0
    var writers = 0
    var writeRequests = 0

    val readLock = ReadLock(this)
    val writeLock = WriteLock(this)
}