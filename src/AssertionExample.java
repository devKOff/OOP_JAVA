

public class AssertionExample {
    public static void main(String[] args) {
        int x = 10;
        assert x > 0 : "x must be positive";
        System.out.println("x is " + x);

        x = -5;
        assert x > 0 : "x is negative: " + x; // This will throw AssertionError if assertions are enabled
    }
}