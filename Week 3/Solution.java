public class Solution {
    public int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.gcd(6, 9));
    }
}
