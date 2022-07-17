package innerclass;

public class OutClass2<T> {

    private final Anonymous<T> logic;

    public OutClass2(Anonymous<T> logic) {
        this.logic = logic;
    }

    public void start(T... param) {
        T run = logic.run(param);
        System.out.println("run = " + run);
    }
}
