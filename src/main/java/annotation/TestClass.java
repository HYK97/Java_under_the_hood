package annotation;

public class TestClass {
    public static void main(String[] args) {

    }

    @TestAnnotation(number = 10, text = "ㄴㄴ")
    public void test2() {
    }

    @TestAnnotation(number = 1)
    public void testMethod1() {

    }
}
