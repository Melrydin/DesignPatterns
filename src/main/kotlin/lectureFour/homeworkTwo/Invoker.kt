package lectureFour.homeworkTwo

import lectureFour.homeworkTwo.commands.Command

class Invoker {
    private var undoHistory: MutableList<Command> = mutableListOf()
    private var redoHistory: MutableList<Command> = mutableListOf()

    fun execute(command: Command){
        command.execute()
        undoHistory.add(command)
        redoHistory.clear()
    }

    fun undo(){
        if (canUndo()){
            val command = undoHistory.removeLast()
            command.undo()
            redoHistory.add(command)
        }
    }

    fun redo(){
        if (canRedo()){
            val command = redoHistory.removeLast()
            command.execute()
            undoHistory.add(command)
        }
    }

    fun canUndo(): Boolean{
        return undoHistory.isNotEmpty()
    }

    fun canRedo(): Boolean {
        return redoHistory.isNotEmpty()
    }
}