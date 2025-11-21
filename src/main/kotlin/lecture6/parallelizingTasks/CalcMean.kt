package lecture6.parallelizingTasks

private fun createCalcMeanJobs(intArray: IntArray, numberOfThreads: Int): Array<CalcMeanJob> {
    val calcMeanJobs = Array(numberOfThreads) { CalcMeanJob(intArray, 0, 0) }

    val arrayLength = intArray.size
    val fragmentLength = arrayLength / numberOfThreads
    var currentBeginning = 0
    var currentEnd = fragmentLength - 1

    for (i in 0 until numberOfThreads) {
        calcMeanJobs[i] = CalcMeanJob(intArray, currentBeginning, currentEnd)
        currentBeginning += fragmentLength
        currentEnd += fragmentLength
        if (currentEnd > arrayLength - 1) {
            currentEnd = arrayLength - 1
        }
    }
    return calcMeanJobs
}

fun calcMean(intArray: IntArray, numberOfThreads: Int): Double {
    val calcMeanJobs = createCalcMeanJobs(intArray, numberOfThreads)
    val threads: Array<Thread> = Array(calcMeanJobs.size) { i ->
        Thread(calcMeanJobs[i]).apply { start() }
    }
    var sum = 0.0
    try {
        for (i in threads.indices) {
            threads[i].join()
            sum += calcMeanJobs[i].result
        }
    } catch (e: InterruptedException) {
        throw RuntimeException(e)
    }
    return sum / intArray.size
}