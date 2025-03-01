public class Square implements Expression {
    private Expression expression;

    public Square(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "(" + expression + ")^2";
    }

    @Override
    public double evaluate() {
        return Math.pow(expression.evaluate(), 2);
    }
}
