public class Numeral implements Expression {
    private double value;

    public Numeral() {
        value = 0;
    }

    public Numeral(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public double evaluate() {
        return value;
    }
}
