package lecture9

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class NumberPrinterContinuationTest {

    @Test
    fun scheduler(){
        val contA = NumberPrinterContinuation(null)
        contA.name = "A"

        val contB = NumberPrinterContinuation(null)
        contB.name = "B"

        var isTurnA = true

        println("Other code running on ${Thread.currentThread().name}")

        while (contA.label != 3 || contB.label != 3) {
            if (isTurnA) {
                if (contA.label != 3) {
                    contA.resume()
                }
            } else {
                if (contB.label != 3) {
                    contB.resume()
                }
            }
            isTurnA = !isTurnA
        }
    }

}