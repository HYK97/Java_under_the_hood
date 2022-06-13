package homework.ten;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Animal> animal =new ArrayList<>();
        animal.add(new Animal("미지의동물"));
        animal.add(new Cat("고양이",4,"코숏"));
        animal.add(new Dog("강아지",4,"리트리버"));

        animal.stream().forEach(
                i -> {
                    if (i instanceof Cat) {
                        ((Cat) i).howling();
                    } else if (i instanceof Dog) {
                        ((Dog) i).eat();
                    } else {
                        i.Move();
                    }

                }
        );
    }
}
