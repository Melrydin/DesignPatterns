package lecture1.homework2

data class Node(val name: String)

class Graph {
    val adjacencyList: MutableMap<Node, MutableSet<Node>> = mutableMapOf()

    fun addEdge(from: Node, to: Node) {
        val neighbors = adjacencyList.getOrPut(from) {mutableSetOf()}
        neighbors.add(to)
    }

    fun isReachable(startNode: Node, endNodeName: String): Boolean {
        val visited = mutableSetOf<Node>()

        if (startNode.name == endNodeName) {
            return true
        }

        if (startNode !in adjacencyList) {
            return false
        }

        return dfsRecursive(startNode, endNodeName, visited)
    }

    private fun dfsRecursive(currentNode: Node, targetName: String, visited: MutableSet<Node>): Boolean {
        if (currentNode in visited) {
            return false
        }

        visited.add(currentNode)
        val neighbors = adjacencyList[currentNode]

        if (neighbors != null) {
            for (neighbor in neighbors) {

                if (neighbor.name == targetName) {
                    return true
                }
                if (dfsRecursive(neighbor, targetName, visited)) {
                    return true
                }
            }
        }

        return false
    }
}