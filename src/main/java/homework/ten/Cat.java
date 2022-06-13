package homework.ten;

public class Cat extends Animal{

    private String kind;

    public Cat(String name,String kind) {
        super(name);
        this.kind=kind;
    }

    public Cat(String name, int leg, String kind) {
        super(name, leg);
        this.kind = kind;
    }

    @Override
    public void Move() {
        System.out.println(kind+"종류의 "+name+ "가 움직입니다");
    }

    public void howling() {
        System.out.println(name+"가 이렇게 짖습니다 야옹");
    }
}
