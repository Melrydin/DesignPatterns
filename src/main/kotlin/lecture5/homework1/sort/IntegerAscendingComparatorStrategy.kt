package lecture5.homework1.sort

class IntegerAscendingComparatorStrategy: ComparatorStrategy {
    override fun isFirstBeforeSecond(first: Any, second: Any): Boolean {
        if (first is Int && second is Int) {
            return first <= second
        }
        return false
    }
}