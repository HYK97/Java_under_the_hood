package packagetest.main;
/**
 * 하위패키지나 상위 패키지 상관없이
 * 같은 패키지에있는 class만 import 안하고 하위 혹은 상위 패키지 안에있는 class는 기본적으로 import처리를 해야함.
 * */
import packagetest.main.sub.Sub;
import static packagetest.main.sub.Sub.staticSubMethod;

public class Main {
    public void mainMethod() {


    }
    public static void staticMainMethod() {

    }

    public static void main(String[] args) {
        Sub sub =new Sub();
        sub.subMethod();
        staticSubMethod();
    }
}
