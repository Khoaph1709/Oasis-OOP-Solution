
public class Prime {

    /**
     * Kiểm tra một số nguyên dương n có phải là số nguyên tố hay không. Số
     * nguyên tố là số nguyên dương lớn hơn 1 chỉ chia hết cho 1 và chính nó.
     *
     * @param n Số nguyên dương cần kiểm tra.
     * @return Trả về true nếu n là số nguyên tố, ngược lại trả về false.
     */
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(2)); // true
        System.out.println(isPrime(3)); // true
        System.out.println(isPrime(4)); // false
        System.out.println(isPrime(5)); // true
        System.out.println(isPrime(6)); // false
    }
}
