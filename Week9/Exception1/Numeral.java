public class Numeral extends Expression {
    private double value;

    public Numeral() {
        value = 0;
    }

    public Numeral(double value) {
        this.value = value;
    }

    
    @Override
    public String toString() {
        if (value % 1 == 0) {
            return String.valueOf((int) value);
        } else {
            return String.valueOf(value);
        }
    }

    @Override
    public double evaluate() {
        return value;
    }
}
