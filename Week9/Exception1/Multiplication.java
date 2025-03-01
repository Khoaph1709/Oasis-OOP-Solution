public class Multiplication extends BinaryExpression {
    public Multiplication(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public String toString() {
        return "(" + left + " * " + right + ")";
    }

    @Override
    public double evaluate() {
        return left.evaluate() * right.evaluate();
    }
}
