package datatype.reference.string;

public class StringCompareTo {
    /**
     * compareTo 는 매개변수를 기준으로 한다.
     * */
    public static void main(String[] args) {
        String a ="a";
        String b ="b";
        String c= "c";

        /*
        * String compareTo
        * */
        System.out.println(a.compareTo(b));
        System.out.println(b.compareTo(a));
        System.out.println(c.compareTo(a));


        /*
         * 참고 Integer compareTo
         * */

        Integer i1=1;
        Integer i2=2;
        Integer i3=3;
        System.out.println(i1.compareTo(i2));
        System.out.println(i2.compareTo(i1));
        System.out.println(i3.compareTo(i1));
    }
}
