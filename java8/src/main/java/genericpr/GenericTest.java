package genericpr;

public class GenericTest<T> {
    T data;

    public GenericTest(T data) {
        this.data = data;
    }

    public GenericTest() {
    }

    @Override
    public String toString() {
        return "GenericTest{" +
                "data=" + data +
                '}';
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
