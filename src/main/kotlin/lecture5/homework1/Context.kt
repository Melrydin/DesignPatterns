package lecture5.homework1

class Context(var arithmeticOperation: ArithmeticOperation) {
    fun executeOperation(operand1: Int, operand2: Int): Int {
        return arithmeticOperation.doOperation(operand1, operand2)
    }
}