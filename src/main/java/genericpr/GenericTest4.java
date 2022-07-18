package genericpr;

public class GenericTest4 {

    public void method(GenericTest3<? extends Animal> object) {
        object.method();
    }
}
