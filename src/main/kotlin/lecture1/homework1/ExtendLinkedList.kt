package lecture1.homework1

class LinkedList<T>(var head : Node<T>?) {
    fun prepend(value : T) {
        this.head = Node(value, next = this.head)
    }

    fun append(value: T) {
        if (this.head == null) {
            this.head = Node(value)
        } else {
            this.head!!.appendRecursive(value)
        }
    }

    fun insert(index: Int, value : T) {
        if (index == 0){
            prepend(value)
            return
        }

        if (head == null){
            append(value)
            return
        }

        var predecessor = head
        var currentIndex = 0

        while (currentIndex < index - 1 && predecessor?.next != null) {
            predecessor = predecessor.next
            currentIndex++
        }

        val newNode = Node(value)
        val successorNode = predecessor!!.next
        predecessor.next = newNode
        newNode.next = successorNode

    }
}

class Node<T>(var value : T, var next : Node<T>? = null) {
    fun appendRecursive(value: T) {
        if (this.next == null) {
            this.next = Node(value)
        } else {
            this.next!!.appendRecursive(value)
        }
    }
}