/**
 * Lớp Fraction đại diện cho một phân số với tử số và mẫu số.
 * Cung cấp các phương thức để cộng, trừ, nhân, chia và làm giảm phân số.
 */
public class Fraction {
    private int numerator; // Tử số của phân số
    private int denominator; // Mẫu số của phân số

    /**
     * Khởi tạo phân số với tử số và mẫu số được chỉ định.
     *
     * @param numerator Tử số của phân số.
     * @param denominator Mẫu số của phân số.
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Khởi tạo phân số mặc định 0/1.
     */
    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    /**
     * Lấy tử số của phân số.
     *
     * @return Tử số của phân số.
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Cập nhật tử số của phân số.
     *
     * @param numerator Tử số mới của phân số.
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * Lấy mẫu số của phân số.
     *
     * @return Mẫu số của phân số.
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Cập nhật mẫu số của phân số.
     * Nếu mẫu số bằng 0, mẫu số không được thay đổi.
     *
     * @param denominator Mẫu số mới của phân số.
     */
    public void setDenominator(int denominator) {
        if (denominator != 0) {
            this.denominator = denominator;
        }
    }

    /**
     * Tính ước chung lớn nhất (GCD) của hai số nguyên a và b.
     *
     * @param a Số nguyên thứ nhất.
     * @param b Số nguyên thứ hai.
     * @return Ước chung lớn nhất của a và b.
     */
    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    /**
     * Rút gọn phân số bằng cách chia tử số và mẫu số cho ước chung lớn nhất.
     *
     * @return Phân số đã rút gọn.
     */
    public Fraction reduce() {
        int greaterCommonDivisor = gcd(numerator, denominator);
        numerator /= greaterCommonDivisor;
        denominator /= greaterCommonDivisor;
        return this;
    }

    /**
     * Cộng hai phân số.
     *
     * @param other Phân số khác để cộng.
     * @return Phân số kết quả sau khi cộng.
     */
    public Fraction add(Fraction other) {
        int newNumerator = numerator * other.denominator + other.numerator * denominator;
        int newDenominator = denominator * other.denominator;
        denominator = newDenominator;
        numerator = newNumerator;
        return reduce();
    }

    /**
     * Trừ hai phân số.
     *
     * @param other Phân số khác để trừ.
     * @return Phân số kết quả sau khi trừ.
     */
    public Fraction subtract(Fraction other) {
        int newNumerator = numerator * other.denominator - other.numerator * denominator;
        int newDenominator = denominator * other.denominator;
        denominator = newDenominator;
        numerator = newNumerator;
        return reduce();
    }

    /**
     * Nhân hai phân số.
     *
     * @param other Phân số khác để nhân.
     * @return Phân số kết quả sau khi nhân.
     */
    public Fraction multiply(Fraction other) {
        numerator *= other.numerator;
        denominator *= other.denominator;
        return reduce();
    }

    /**
     * Chia hai phân số.
     * Nếu mẫu số của phân số khác là 0, phương thức sẽ không thay đổi phân số.
     *
     * @param other Phân số khác để chia.
     * @return Phân số kết quả sau khi chia.
     */
    public Fraction divide(Fraction other) {
        if (other.numerator != 0) {
            numerator *= other.denominator;
            denominator *= other.numerator;
            return reduce();
        }
        return reduce(); // Nếu phân số khác có tử số = 0, không thực hiện phép chia
    }

    /**
     * Kiểm tra xem hai phân số có bằng nhau hay không.
     * Hai phân số được coi là bằng nhau nếu tích chéo của chúng bằng nhau.
     * Ví dụ: 1/2 == 2/4 vì 1 * 4 == 2 * 2.
     *
     * @param obj Đối tượng để so sánh.
     * @return true nếu hai phân số bằng nhau, false nếu không.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Fraction) {
            Fraction other = (Fraction) obj;
            return numerator * other.denominator == denominator * other.numerator;
        }
        return false;
    }

    /**
     * Chuyển phân số thành chuỗi.
     *
     * @return Chuỗi mô tả phân số dưới dạng "tử số/mẫu số".
     */
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    /**
     * Hàm main để kiểm tra các phương thức của lớp Fraction.
     * Ví dụ cộng, trừ, nhân giữa hai phân số.
     *
     * @param args Tham số dòng lệnh.
     */
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        System.out.println(f1.add(f2)); // Kết quả cộng: 5/6
        System.out.println(f1.subtract(f2)); // Kết quả trừ: 1/6
        System.out.println(f1.multiply(f2)); // Kết quả nhân: 1/6
        System.out.println(f1.divide(f2)); // Kết quả chia: 3/2
    }
}
