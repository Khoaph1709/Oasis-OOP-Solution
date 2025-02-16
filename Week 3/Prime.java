public class Prime {
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
