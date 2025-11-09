package lectureFour.homeworkTwo.commands

import lectureFour.homeworkTwo.Item

class ChangeNameCommand(private var item: Item, private var newName: String): Command {
    private val oldName: String = item.name

    override fun execute() {
        item.name = newName
    }

    override fun undo() {
        item.name = oldName
    }
}