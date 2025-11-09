package lecture1.homework1

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ExtendLinkedList {

    lateinit var linkedList: LinkedList<Int>

    @BeforeEach
    fun setup(){
        linkedList = LinkedList<Int>(Node(1))
    }

    @Test
    fun testPrepend(){
        linkedList.prepend(10)

        assertEquals(10,linkedList.head?.value)
    }

    @Test
    fun testPrepend_OnEmptyList(){
        linkedList.head = null

        linkedList.prepend(10)

        assertEquals(10, linkedList.head?.value)
    }

    @Test
    fun testAppend(){
        linkedList.append(2)

        assertEquals(2,linkedList.head?.next?.value)

    }

    @Test
    fun testAppend_OnLongerList(){
        linkedList.append(2)

        linkedList.append(3)

        assertEquals(3, linkedList.head?.next?.next?.value)
    }

    @Test
    fun testAppend_HeadIsNull(){
        linkedList.head = null

        linkedList.append(10)

        assertEquals(10, linkedList.head?.value)
    }

    @Test
    fun testInsert(){
        linkedList.head?.next = Node(3)

        linkedList.insert(1,2)

        assertEquals(2, linkedList.head?.next?.value)
    }

    @Test
    fun testInsert_NewHead(){
        linkedList.insert(0,30)

        assertEquals(30, linkedList.head?.value)
    }

    @Test
    fun testInsert_OutOfList(){
        linkedList.insert(30,30)

        assertEquals(30, linkedList.head?.next?.value)
    }

    @Test
    fun testLInsert_ByABigList(){
        linkedList.append(2)
        linkedList.append(3)
        linkedList.insert(2,10)

        assertEquals(10, linkedList.head?.next?.next?.value)
    }

    @Test
    fun testInsert_OnEmptyListWithIndexOne(){
        linkedList.head = null

        linkedList.insert(1, 10)

        assertEquals(10, linkedList.head?.value)
    }
}