package genericpr;

public class GenericTest3<T extends Animal> {
    T object;

    public GenericTest3(T object) {
        this.object = object;
    }

    public static void main(String[] args) {
        GenericTest3<Bird> test = new GenericTest3<>(new Bird());
        test.method();

        GenericTest4 test1 = new GenericTest4();
        test1.method(new GenericTest3<>(new Bird()));


    }

    public void method() {
        object.run();
    }


}
