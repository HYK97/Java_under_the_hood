package effective_java.item2.privateconstructor;

public class PrivateConstructorUtils {

    //상속해도 부모의 생성자를 호출할수없기때문에 인스턴스를 만들수없다.
    //인스턴스 생성방지용 이라고 주석을 달자.
    private PrivateConstructorUtils() {
        throw new IllegalAccessError("생성 불가능");
    }


    public static Integer sum(int a, int b) {
        return a + b;
    }


    public static Integer minus(int a, int b) {
        return a - b;
    }
}
