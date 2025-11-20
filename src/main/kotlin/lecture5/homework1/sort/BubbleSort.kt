package lecture5.homework1.sort

class BubbleSort(var comparatorStrategy: ComparatorStrategy) {
    fun sort(inputList: MutableList<Any>): MutableList<Any> {
        val n = inputList.size
        for (i in 0 until n-1){
            for (j in 0 until n-i-1){
                if (!comparatorStrategy.isFirstBeforeSecond(inputList[j], inputList[j+1])){
                    swap(inputList,j, j+1)
                }
            }
        }
        return inputList
    }

    private fun swap(inputList: MutableList<Any>, i: Int, j: Int) {
        val tmp = inputList[i]
        inputList[i] = inputList[j]
        inputList[j] = tmp
    }
}