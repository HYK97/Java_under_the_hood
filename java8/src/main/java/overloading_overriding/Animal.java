package overloading_overriding;

public class Animal {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog();
        Animal cat = new Cat();
        System.out.println("cat = " + cat);
        animal.move(); // Animal is moving.
        dog.move();    // Dog is running.
        cat.move();    // Cat is jumping.
    }

    public void move() {
        System.out.println("Animal is moving.");
    }

}

class Dog extends Animal {
    @Override
    public void move() {
        System.out.println("Dog is running.");
    }
}

class Cat extends Animal {
    @Override
    public void move() {
        System.out.println("Cat is jumping.");
    }
}

