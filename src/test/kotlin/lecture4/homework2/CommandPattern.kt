package lecture4.homework2

import lecture4.homework2.commands.ChangeNameCommand
import lecture4.homework2.commands.ChangePriceCommand
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CommandPattern {

    @Test
    fun shopItemCommandsTest() {
        val oldName = "A4 Paper"
        val oldPrice = 299
        val item = Item(oldName, oldPrice)
        val newName = "A3 Paper"
        val newPrice = 599
        val invoker = Invoker()
        val changeNameCommand =
            ChangeNameCommand(item, newName)
        val changePriceCommand =
            ChangePriceCommand(item, newPrice)
        invoker.execute(changeNameCommand)
        invoker.execute(changePriceCommand)
        assertEquals(item.name, newName)
        assertEquals(item.price, newPrice)
        assertTrue(invoker.canUndo()) // can undo
        assertFalse(invoker.canRedo()) // but cannot redo if nothing undone
        invoker.undo() // undo change price
        assertEquals(item.name, newName) // name stays new
        assertEquals(item.price, oldPrice) // but price is old
        assertTrue(invoker.canUndo()) // can undo once more
        assertTrue(invoker.canRedo()) // also can redo now

        invoker.undo() // undo change name
        assertEquals(item.name, oldName) // name also old now
        assertEquals(item.price, oldPrice) // price is old as well
        assertFalse(invoker.canUndo()) // nothing more to undo
        assertTrue(invoker.canRedo()) // but to redo
        invoker.redo()
        assertEquals(item.name, newName) // name new again
        assertEquals(item.price, oldPrice) // but price is old
        assertTrue(invoker.canUndo()) // can again undo
        assertTrue(invoker.canRedo()) // also can redo
        invoker.redo()
        assertEquals(item.name, newName) // name new again
        assertEquals(item.price, newPrice) // also price is new again
        assertTrue(invoker.canUndo()) // can undo
        assertFalse(invoker.canRedo()) //
    }
}