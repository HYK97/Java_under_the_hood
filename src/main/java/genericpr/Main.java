package genericpr;

public class Main {
    public static void main(String[] args) {
        GenericTest<String> data = new GenericTest<>();
        GenericTest<Integer> data2 = new GenericTest<>();
        print(data, "String");
        print(data2, 1);

    }

    public static <T> void print(GenericTest<T> data, T value) {
        data.setData(value);
        System.out.println("data = " + data);
    }
}
