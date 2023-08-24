package inheritance;

public class Child extends Parent {
    public Child() {
        super("남자");
        System.out.println(" 이전");
        System.out.println(" Child 기본생성자");
    }


    public Child(String name) {
        //super(); 이건 생성자 모두에 기본적으로 들어가있음.
        System.out.println(" 이전");
        System.out.println("Child String 생성자");
    }

    public Child(int data) {
        System.out.println("Child int  생성자");
    }

    @Override
    public void printName() {
        System.out.println("Child printName");
    }

    public void printAge() {
        System.out.println("printAge ");
    }

    @Override
    public void innerMethod() {
        System.out.println("Child InnerMethod");
    }
}
