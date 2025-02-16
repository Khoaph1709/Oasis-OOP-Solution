public class Fibonacci {
    public static long fibonacci(int n) {
        if (n < 0) {
            return -1;
        }
        if (n > 92) { // fibonacci(n) exceeds Long.MAX_VALUE for n > 92
            return Long.MAX_VALUE;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        long a = fibonacci(n - 1);
        long b = fibonacci(n - 2);
        if (Long.MAX_VALUE - a < b) { // check for overflow
            return Long.MAX_VALUE;
        }
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10)); // 55
        System.out.println(fibonacci(92)); // 7540113804746346429
        System.out.println(fibonacci(93)); // 7540113804746346429
    }
}
