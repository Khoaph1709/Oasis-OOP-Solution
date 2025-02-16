public class HelloWorld {
    public static String printHello() {
        return "HelloWorld";
    }

    public static String printHello(String name) {
        return "Hello " + name;
    }

    public static void main(String[] args) {
        System.out.println(printHello());
    }
}
