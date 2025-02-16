public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        if (denominator != 0) {
            this.denominator = denominator;
        }
    }

    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    public Fraction reduce() {
        int greaterCommonDivisor = gcd(numerator, denominator);
        numerator /= greaterCommonDivisor;
        denominator /= greaterCommonDivisor;
        return this;
    }

    public Fraction add(Fraction other) {
        int newNumerator = numerator * other.denominator + other.numerator * denominator;
        int newDenominator = denominator * other.denominator;
        denominator = newDenominator;
        numerator = newNumerator;
        return reduce();
    }

    public Fraction subtract(Fraction other) {
        int newNumerator = numerator * other.denominator - other.numerator * denominator;
        int newDenominator = denominator * other.denominator;
        denominator = newDenominator;
        numerator = newNumerator;
        return reduce();
    }

    public Fraction multiply(Fraction other) {
        numerator *= other.numerator;
        denominator *= other.denominator;
        return reduce();
    }

    public Fraction divide(Fraction other) {
        if (other.numerator != 0) {
            numerator *= other.denominator;
            denominator *= other.numerator;
            return reduce();
        }
        return reduce();
    }

    public boolean euqals(Object obj) {
        if (obj instanceof Fraction) {
            Fraction other = (Fraction) obj;
            return numerator * other.denominator == denominator * other.numerator;
        }
        return false;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        System.out.println(f1.add(f2));
        System.out.println(f1.subtract(f2));
        System.out.println(f1.multiply(f2));
        System.out.println(f1.divide(f2));
        System.out.println(f1.euqals(f2));
    }
}
