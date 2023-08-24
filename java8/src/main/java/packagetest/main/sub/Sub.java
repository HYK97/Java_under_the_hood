package packagetest.main.sub;

import packagetest.main.Main;

import static packagetest.main.Main.staticMainMethod;

public class Sub {
    public static void main(String[] args) {
        staticMainMethod();
        Main main = new Main();
        main.mainMethod();
    }

    public void subMethod() {


    }
    public static void staticSubMethod() {

    }

}
