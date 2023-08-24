package lang;

public class javaLangNumber {
    public static void main(String[] args) {
        String value = "1";
        String value2 = "2";

        /**
         * parse 는 기본자료형을 리턴한다 -> ? -> parseint -> int형
         * 반대로 valueOf는 참조 자료형을 리턴한다 -> ? ->valueOf ->Integer형
         * */
        int i1 = Integer.parseInt(value);
        int i2 = Integer.parseInt(value2);
        System.out.println(i1 + i2);
        Integer in1 = Integer.valueOf(value);
        Integer in2 = Integer.valueOf(value2);
        System.out.println(in1 + in2 + "2");
    }
}
