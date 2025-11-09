package lecture4.homework2.commands

interface Command {
    fun execute()
    fun undo()
    fun redo()
}