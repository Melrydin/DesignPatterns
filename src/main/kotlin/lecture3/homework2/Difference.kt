package lecture3.homework2

class Difference(left: Expression, right: Expression): BinaryExpression(left, right) {
    override fun getValue(): Int {
        return left.getValue() - right.getValue()
    }
}