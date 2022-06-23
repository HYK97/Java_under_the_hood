package annotation;

import java.lang.reflect.Method;

public class MainClass {
    public static void main(String[] args) {
        Method[] declaredMethods = TestClass.class.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            TestAnnotation annotation = declaredMethod.getAnnotation(TestAnnotation.class);
            if (annotation != null) {
                System.out.println(annotation.number() + "  " + annotation.text());
            } else {
                System.out.println(" 없음 ");
            }
        }
    }

}
