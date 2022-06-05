package operatior;

public class ConditionalOperator {

    public static void main(String[] args) {

        /**
         * && 일경우 왼쪽 항이 false면 오른쪽 항은 연산을 하지않는다
         * & 은 항상 오른쪽 왼쪽 둘다 연산후 true인지 비교한다.
         * */
        if (testMethod1() && testMethod2()) {
            System.out.println("&&");
        }
        if (testMethod1() & testMethod2()) {
            System.out.println("&");
        }

    }

    public static Boolean testMethod1 (){
        System.out.println("false 연산");
        return false;
    }
    public static Boolean testMethod2 (){
        System.out.println("true 연산");
        return true;
    }
}
