
import java.util.jar.Attributes;

public class Fraction {
    private int numerator;
    private int denominator;

    /**
     * Tạo một phân số với tử số và mẫu số cho trước.
     * @param numerator tử số.
     * @param denominator mẫu số.
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator != 0) {
            this.denominator = denominator;
        } else {
            this.denominator = 1;
        }
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

    /**
     * Rút gọn phân số.
     * @return phân số sau khi rút gọn.
     */
    public Fraction reduce() {
        int greaterCommonDivisor = gcd(numerator, denominator);
        numerator /= greaterCommonDivisor;
        denominator /= greaterCommonDivisor;
        return this;
    }

    /**
     * Cộng hai phân số.
     * @param other phân số cần cộng.
     * @return phân số tổng.
     */
    public Fraction add(Fraction other) {
        if (other != null) {
            int newNumerator = numerator * other.denominator + other.numerator * denominator;
            int newDenominator = denominator * other.denominator;
            denominator = newDenominator;
            numerator = newNumerator;
            return this.reduce();
        }
        return this.reduce();
    }

    /**
     * Trừ hai phân số.
     * @param other phân số cần trừ.
     * @return phân số hiệu.
     */
    public Fraction subtract(Fraction other) {
        if (other != null) {
            int newNumerator = numerator * other.denominator - other.numerator * denominator;
            int newDenominator = denominator * other.denominator;
            denominator = newDenominator;
            numerator = newNumerator;
            return this.reduce();
        }
        return this.reduce();
    }

    /**
     * Nhân hai phân số.
     * @param other phân số cần nhân.
     * @return phân số tích.
     */
    public Fraction multiply(Fraction other) {
        if (other != null) {
            numerator *= other.numerator;
            denominator *= other.denominator;
            return this.reduce();
        }
        return this.reduce();
    }

    /**
     * Chia hai phân số.
     * @param other phân số cần chia.
     * @return phân số thương.
     */
    public Fraction divide(Fraction other) {
        if (other.numerator != 0 && other != null) {
            numerator *= other.denominator;
            denominator *= other.numerator;
            return this.reduce();
        }
        return this.reduce();
    }

    /**
     * So sánh hai phân số.
     * @param obj phân số cần so sánh.
     * @return true nếu hai phân số bằng nhau, ngược lại trả về false.
     */
    @Override
    public boolean equals(Object obj) {
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
        System.out.println(name);
    }
}
l