package lecture6.parallelizingTasks

internal class CalcMeanJob(private val intArray: IntArray, private val fromIndex: Int, private val toIndex: Int): Runnable {
    var result: Double = 0.0

    override fun run() {
        for (i in fromIndex..toIndex) {
            if (i < intArray.size) {
                result += intArray[i]
            }
        }
    }
}