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

    @Test
    fun testWrongTypeInput() {
        val bubbleSort = BubbleSort(IntegerAscendingComparatorStrategy())
        var wrongData = mutableListOf<Any>("A", "B")
        bubbleSort.sort(wrongData)
        assertEquals(mutableListOf("B", "A"), wrongData)

        bubbleSort.comparatorStrategy = IntegerDescendingComparatorStrategy()
        wrongData = mutableListOf("A", "B")
        bubbleSort.sort(wrongData)
        assertEquals(mutableListOf("B", "A"), wrongData)
    }

    @Test
    fun testMixedTypeInput() {
        val bubbleSort = BubbleSort(IntegerAscendingComparatorStrategy())
        var wrongData = mutableListOf<Any>(1 , "B")
        bubbleSort.sort(wrongData)
        assertEquals(mutableListOf("B", 1), wrongData)

        bubbleSort.comparatorStrategy = IntegerDescendingComparatorStrategy()
        wrongData = mutableListOf(1 , "B")
        bubbleSort.sort(wrongData)
        assertEquals(mutableListOf("B", 1), wrongData)
    }
}