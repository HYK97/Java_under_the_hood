package overloading_overriding;

public class Calculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int result1 = calculator.add(1, 2);        // add(int, int) 호출
        double result2 = calculator.add(1.5, 2.5); // add(double, double) 호출
        int result3 = calculator.add(1, 2, 3);     // add(int, int, int) 호출
    }

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

}
