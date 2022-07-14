package inheritance;

public class Parent {
    private String sex;

    // 기본생성자가 없을시엔 super를 이용해 명시적으로 표현해야한다.
    public Parent() {
        System.out.println("parent  기본생성자");
    }

    public Parent(String sex) {
        this.sex = sex;
        System.out.println("parent  String 생성자" + sex);
    }

    public void printName() {
        System.out.println("parent printName");
    }

    public void printSex() {
        System.out.println(" parent " + sex);
        innerMethod();
    }

    public void innerMethod() {
        System.out.println("Parent InnerMethod");
    }
}
