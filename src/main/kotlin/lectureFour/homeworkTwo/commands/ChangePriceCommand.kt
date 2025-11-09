package lectureFour.homeworkTwo.commands

import lectureFour.homeworkTwo.Item

class ChangePriceCommand(private val item: Item, private val newPrice: Int): Command {
    private val oldPrice: Int = item.price

    override fun execute() {
        item.price = newPrice
    }

    override fun undo() {
        item.price = oldPrice
    }
}