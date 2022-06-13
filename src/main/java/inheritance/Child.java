package inheritance;

public class Child extends Parent{
    public Child() {
    }

    public Child(String name) {
    }

    @Override
    public void printName() {
        System.out.println("Child printName");
    }

    public void printAge() {
        System.out.println("printAge ");
    }
}
