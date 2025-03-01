public class testExpression {
    public static void main(String[] args) {
        // Test case 1: Simple addition (1 + 2)
        Expression exp1 = new Addition(new Numeral(1), new Numeral(2));
        System.out.println("1 + 2 = " + exp1);

        // Test case 2: Simple multiplication (3 * 4)
        Expression exp2 = new Multiplication(new Numeral(3), new Numeral(4));
        System.out.println("3 * 4 = " + exp2);

        // Test case 3: Complex expression ((1 + 2) * 3)
        Expression exp3 = new Multiplication(new Addition(new Numeral(1), new Numeral(2)), new Numeral(3));
        System.out.println("(1 + 2) * 3 = " + exp3);

        // Test case 4: More complex expression ((2 * 3) + (4 * 5))
        Expression exp4 = new Addition(
            new Multiplication(new Numeral(2), new Numeral(3)),
            new Multiplication(new Numeral(4), new Numeral(5))
        );
        System.out.println("(2 * 3) + (4 * 5) = " + exp4);

        // Test case 5: Nested operations (((1 + 2) * 3) + 4)
        Expression exp5 = new Addition(
            new Multiplication(new Addition(new Numeral(1), new Numeral(2)), new Numeral(3)),
            new Numeral(4)
        );
        System.out.println("((1 + 2) * 3) + 4 = " + exp5);

        // Test case 6: Simple square (2^2)
        Expression exp6 = new Square(new Numeral(2));
        System.out.println("2^2 = " + exp6);

        // Test case 7: Square of an addition ((1 + 2)^2)
        Expression exp7 = new Square(new Addition(new Numeral(1), new Numeral(2)));
        System.out.println("(1 + 2)^2 = " + exp7);

        // Test case 8: Complex expression with square ((2^2) * 3)
        Expression exp8 = new Multiplication(new Square(new Numeral(2)), new Numeral(3));
        System.out.println("(2^2) * 3 = " + exp8);

        // Test case 9: Nested squares ((2^2)^2)
        Expression exp9 = new Square(new Square(new Numeral(2)));
        System.out.println("(2^2)^2 = " + exp9);
        System.out.println(exp9.evaluate());
    }
}


