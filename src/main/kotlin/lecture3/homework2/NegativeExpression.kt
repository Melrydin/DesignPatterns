package lecture3.homework2

class NegativeExpression(expression: Expression): UnaryExpression(expression) {
    override fun getValue(): Int {
        return -expression.getValue()
    }
}