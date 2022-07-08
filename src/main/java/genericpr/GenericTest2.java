package genericpr;

/**
 * 제네릭도 스코프가 있음 앞에 선언된 제네릭만 사용가능
 */
public class GenericTest2<X> {

    X data1;
    //ex ) class에 X만 선언 되어있고 T는 되지않았으므로 사용불가능
    // T data;
    Object data2;

    public <T> GenericTest2(T data2) {
        this.data2 = data2;
    }

    public GenericTest2() {
    }

    public <T> void setData2(T data2) {
        this.data2 = data2;
    }

    public void setData1(X data1) {
        this.data1 = data1;
    }

    public void printClass() {
        System.out.println("data1.getClass().getName() = " + data1.getClass().getName());
        System.out.println("data2.getClass().getName() = " + data2.getClass().getName());
        if (data2 instanceof Number) {
            System.out.println("data2 = " + data2);
        }
        if (data1 instanceof String) {
            System.out.println("data1 = " + data1);
        }

    }
}
