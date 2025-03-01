public class Division extends BinaryExpression {
    public Division(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public String toString() {
        return "(" + left + " / " + right + ")";
    }

    @Override
    public double evaluate() throws ArithmeticException {
        if (right.evaluate() == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return left.evaluate() / right.evaluate();
    }
}
