package lecture5.homework1.sort

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class StrategyTest {

    @Test
    fun sortTest() {
        val bubbleSort = BubbleSortLambda { first, second ->
            if (first is Int && second is Int) {
                first < second
            } else {
                false
            }
        }
        val a = mutableListOf<Any>(1, 3, 2)
        val sortedList = bubbleSort.sort(a)
        assertEquals(mutableListOf(1, 2, 3), sortedList)
    }

    @Test
    fun intBubbleSortTestIntegerAscending() {
        val bubbleSort = BubbleSort(IntegerAscendingComparatorStrategy())
        val a = mutableListOf<Any>(1, 3, 2)
        var sortedList = bubbleSort.sort(a)
        assertEquals(mutableListOf(1, 2, 3), sortedList)
        bubbleSort.comparatorStrategy = IntegerDescendingComparatorStrategy()
        sortedList = bubbleSort.sort(a)
        assertEquals(mutableListOf(3, 2, 1), sortedList)
    }
}