package lecture9

class NumberPrinterContinuation(val completion: Continuation?) : Continuation {
    var name: String = ""
    var i: Int = 0
    var label: Int = 0

    override fun resume() {
        numberPrinter(this)
    }

    fun numberPrinter(cont: NumberPrinterContinuation) {
        when (cont.label) {
            0 -> {
                cont.i = 1
                cont.label = 1
                numberPrinter(cont)
            }
            1 -> {
                if (cont.i <= 2) {
                    println("${cont.name} says ${cont.i} on ${Thread.currentThread().name}")
                    cont.label = 2
                    return
                } else {
                    cont.label = 3
                }
            }
            2 -> {
                cont.i++
                cont.label = 1
                numberPrinter(cont)
            }
        }
    }
}