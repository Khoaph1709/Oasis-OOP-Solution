public class testExpression {
    public static void main(String[] args) {

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

        Expression exp10 = new Square(new Addition(new Addition(new Square(new Numeral(10)), new Square(new Numeral(10))), new Square(new Numeral(10))));
        System.out.println(exp10);
    }
}


