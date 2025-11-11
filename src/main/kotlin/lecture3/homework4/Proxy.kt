package lecture3.homework4

class Proxy(private val imagePath: String): Subject {
    private var realImage: RealSubject? = null
    override fun operation(degrees: Int) {
        if (realImage == null) {
            realImage = RealSubject(imagePath)
        }
        realImage?.operation(degrees)
    }
    fun getFilePath(): String {
        return imagePath
    }
}