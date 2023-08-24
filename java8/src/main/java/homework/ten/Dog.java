package homework.ten;

public class Dog extends Animal{

    private String kind;
    public Dog(String name, String kind) {
        super(name);
        this.kind=kind;
    }

    public Dog(String name, int leg, String kind) {
        super(name, leg);
        this.kind = kind;
    }

    @Override
    public void Move() {
        System.out.println(kind+"종류의 "+name+ "가 움직입니다");
    }

    public void eat() {
        System.out.println(name+"은 사료를 맛있게 먹습니다.");
    }
}
