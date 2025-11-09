package lecture4.homework2.commands

import lecture4.homework2.Item

class ChangePriceCommand(private val item: Item, private val newPrice: Int): Command {
    private var oldPrice: Int = 0

    override fun execute() {
        oldPrice = item.price
        redo()
    }

    override fun undo() {
        item.price = oldPrice
    }

    override fun redo() {
        item.price = newPrice
    }
}