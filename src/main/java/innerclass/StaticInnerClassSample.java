package innerclass;

public class StaticInnerClassSample {
    public static void main(String[] args) {
        /**
         * out 에 private static class인 노트는 캡슐화 해서 사용되고 있음.
         * 외부에서 사용불가 innerClass 예시
         * */
        OutClass<String, String> out = new OutClass<>();
        out.setData("key1", "data1");
        out.setData("key2", "data3");
        out.setData("key3", "data3");
        out.getDatas();
        String data = out.getKey("key2");
        System.out.println("key1 data = " + data);
        String kkkk = out.getKey("kkkk");


    }
}
