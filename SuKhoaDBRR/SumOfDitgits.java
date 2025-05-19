
import java.util.Scanner;


public class SumOfDitgits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string of digits: ");
        String s = sc.nextLine();
        System.out.println("The sum of those number is " + sum(s));
        System.out.println("The highest digit is " + max(s));
        System.out.println("The lowest digit is " + min(s));
        sc.close();
    }

    public static int sum(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                sum += Character.getNumericValue(ch);
            }
        }
        return sum;
    }

    public static int max(String s) {
        int max = s.charAt(0) - '0';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int num = Character.getNumericValue(ch);
                if (num > max) {
                    max = num;
                }
            }
        }
        return max;
    }

    public static int min(String s) {
        int min = s.charAt(0) - '0';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int num = Character.getNumericValue(ch);
                if (num < min) {
                    min = num;
                }
            }
        }
        return min;
    }
}