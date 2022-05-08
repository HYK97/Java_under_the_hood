package closure.example2;

public class LambdaExpression {

    /**
     * 결론
     * closure은 익명함수와 속도차이가 거의 비슷하지만
     * 외부 변수를 사용하지 않는 람다와 익명함수의 속도는 람다가 최대 60배 빠름
     * */
    private int number= 200;

    public static void main(String[] args) {
        new LambdaExpression().test1();
        new LambdaExpression().test2();
    }

    public void test1() {

        int number =100;


        /**
         * 익명 메서드는  컴파일 시점에 클래스 파일이 추가 된다.
         * 그것을 토대로 런타임시 오브젝트를 생성한다.
         * */
        Runnable anonymous = new Runnable() {
            @Override
            public void run() {
                System.out.println("number = " + number);
            }
        };
        anonymous.run();

        /**
         * 람다는 컴파일 시점에 클래스가 추가되지 않는다
         * static 메서드인 레시피가 추가된다
         * -> 런타임시에 레시피를 통해서 클래스와 오브젝트를 생성
         * desugar method body는
         * static 으로 나오고 파라메터로 value를 캡쳐해서 보내준다.
         * ex)
         * private static void lambda$test$0(int number)
         * */
        Runnable lambda= ()-> System.out.println("number = " + number);
        lambda.run();
    }

    private int number2 =200;
    public void test2() {


        /**
         * 다음과 같이 멤버 변수를 closure 하게 된다면
         * desugar method body는
         * private void lambda$test$0()
         * 과 같이 생성된다.
         * */
        Runnable lambda= ()-> System.out.println("number = " + number2);
        lambda.run();
    }

}
