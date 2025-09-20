interface person {
    int operate(int a, int b);
}

public class lambdaFunction {
    public static void main(String[] args) {
        person sum = (a, b) -> a + b;
        int ans = sum.operate(5, 3);
        System.out.println(ans);
    }
}