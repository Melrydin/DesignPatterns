package lecture5.homework1.sort

interface ComparatorStrategy {
    fun isFirstBeforeSecond(first: Any, second: Any): Boolean
}