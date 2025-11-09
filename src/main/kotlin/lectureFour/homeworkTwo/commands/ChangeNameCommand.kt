package lectureFour.homeworkTwo.commands

import lectureFour.homeworkTwo.Item

class ChangeNameCommand(private var item: Item, private var newName: String): Command {
    private var oldName: String = ""

    override fun execute() {
        oldName = item.name
        redo()
    }

    override fun undo() {
        item.name = oldName
    }

    override fun redo() {
        item.name = newName
    }
}