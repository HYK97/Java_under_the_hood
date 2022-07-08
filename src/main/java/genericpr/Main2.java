package genericpr;

public class Main2 {
    public static void main(String[] args) {
        GenericTest2<String> test1 = new GenericTest2<>();
        test1.setData2(new Integer(10));
        //String일 경우는 instanceof 에 적용디지않아서 print 되지않음.
        //test1.setData2("String");
        test1.setData1("ssss");
        test1.printClass();
    }
}
