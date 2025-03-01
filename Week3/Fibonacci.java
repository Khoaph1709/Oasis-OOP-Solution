public class Fibonacci {

    /**
     * Tính số Fibonacci thứ n.
     * Dãy Fibonacci bắt đầu từ 0 và 1, với mỗi số sau là tổng của hai số liền trước.
     * Nếu n < 0, phương thức trả về -1.
     * Nếu số Fibonacci thứ n vượt quá giá trị tối đa của kiểu dữ liệu long, 
     * phương thức trả về Long.MAX_VALUE.
     *
     * @param n Số tự nhiên n, chỉ số trong dãy Fibonacci cần tính.
     * @return Số Fibonacci thứ n.
     */
    public static long fibonacci(long n) {
        if (n < 0) {
            return -1;
        }

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        long a = 0;
        long b = 1;
        long result = 0;

        for (long i = 2; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;

            if (result < 0) {
                return Long.MAX_VALUE;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        long n = 50;
        System.out.println("Fibonacci thứ " + n + " là: " + fibonacci(n));
    }
}
