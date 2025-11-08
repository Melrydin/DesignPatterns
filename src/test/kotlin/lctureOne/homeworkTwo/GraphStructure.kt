package lctureOne.homeworkTwo

import lectureOne.homeworkTwo.Graph
import lectureOne.homeworkTwo.Node
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GraphStructure {

    lateinit var graph: Graph

    @BeforeEach
    fun setup(){
        graph = Graph()
    }

    @Test
    fun testAddEdge(){
        val node1 = Node("1")
        val node2 = Node("2")

        graph.addEdge(node1, node2)

        assertTrue(graph.adjacencyList.containsKey(node1))
        assertEquals(mutableSetOf(node2), graph.adjacencyList[node1])
    }

    @Test
    fun testIsReachable(){
        graph.addEdge(Node("1"), Node("2"))
        graph.addEdge(Node("2"), Node("4"))

        val isReachable = graph.isReachable(Node("1"), "4")

        assertTrue(isReachable)
    }

    @Test
    fun testIsReachable_StartNodeNotInGraph(){
        graph.addEdge(Node("1"), Node("2"))
        graph.addEdge(Node("2"), Node("4"))

        val isReachable = graph.isReachable(Node("5"), "4")

        assertFalse(isReachable)
    }

    @Test
    fun testIsReachable_StartNodeAndTargetTheSame(){
        graph.addEdge(Node("1"), Node("2"))
        graph.addEdge(Node("2"), Node("4"))

        val isReachable = graph.isReachable(Node("1"), "1")

        assertTrue(isReachable)
    }

    @Test
    fun testIsReachable_Loop(){
        graph.addEdge(Node("1"), Node("2"))
        graph.addEdge(Node("2"), Node("1"))

        val isReachable = graph.isReachable(Node("1"), "3")

        assertFalse(isReachable)

    }

    @Test
    fun testIsReachable_ReachesNodeWithNoOutgoingEdges() {
        val nodeA = Node("A")
        val nodeB = Node("B")
        graph.addEdge(nodeA, nodeB)

        val isReachable = graph.isReachable(nodeA, "Z")

        assertFalse(isReachable)
    }
}