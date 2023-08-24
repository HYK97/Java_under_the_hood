package homework.ten;

import java.util.Objects;

public class Animal {
    protected String name;

    protected int leg;

    public Animal(String name) {
        this.name = name;
    }



    public Animal(String name, int leg) {
        this.name = name;
        this.leg = leg;
    }

    public String getName() {
        return name;
    }

    public void Move() {
        System.out.println(name+"가 움직입니다");
    }


}
