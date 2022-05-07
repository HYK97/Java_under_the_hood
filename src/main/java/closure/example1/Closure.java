package closure.example1;

public class Closure {

    private int number= 200;

    public static void main(String[] args) {
        new Closure().test1();
        new Closure().test2();
        new Closure().test3();
        new Closure().test4();
    }

    @Override
    public String toString() {
        return "Closure{" +
                "number=" + number +
                '}';
    }
    //toString 오버로딩
    public <T> String toString(T value) {
        return " toString (T) : " + String.valueOf(value);

    }

    public void test1() {
        System.out.println(" ===================test1===================== ");
        int number =100; // 사실은 Final


        /**
         * Anonymous Method
         *
         * 자바 8부터는 non-local-variable이 final 이 아니더라도 컴파일 오류가 나지 않는다.
         * -> final 이 붙지 않았지만 effectively final 이라고 부른다.
         *
         * 또한 object member field에 접근할때에 this를 사용하면 new Runnable의 field에 접근하게 된다
         * */
        test1Closures("Anonymous Method",
        new Runnable() {
            @Override
            public void run() {
                System.out.println("number = " + Closure.this.number);
            }
        });



        /**
         * Lambda Expressions
         *
         * ()-> System.out.println("number = " + this.number) 이것은 scope가 없다.
         * 따라서 그냥 this를 이용해서 number에 접근이가능
         * */

        test1Closures("Lambda Expressions",()-> System.out.println("number = " + this.number));


    }



    public void test2() {

        System.out.println(" ===================test2===================== ");
        test1Closures("Anonymous this.toString()",
                new Runnable() {

                    @Override
                    public void run() {
                        System.out.println("number = " + this.toString());
                    }
                });

        test1Closures("Anonymous Closure.this.toString() ",
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("number = " + Closure.this.toString());
                    }
                });



        test1Closures("Lambda Expressions",()-> System.out.println("number = " + this.toString()));



    }

    public void test3() {

        System.out.println(" ===================test3===================== ");
        test1Closures("Anonymous toString()",
                new Runnable() {

                    @Override
                    public void run() {
                       // System.out.println("number = " + toString("tt")); //이런식으로 사용하면 메서드를 찾지못해서 오류가난다 shadowing 발생
                        System.out.println("Closure.this.toString(\"test\") = " + Closure.this.toString("test")); //이런식으로 접근해야함
                    }
                });

        //그냥 접근이 가능하다
        test1Closures("Lambda Expressions toString() ",()-> System.out.println("toString(\"test\") = " + toString("test")));


    }


    public void test4() {


        int number =40;
        System.out.println(" ===================test3===================== ");
        test1Closures("Anonymous toString()",
                new Runnable() {

                    @Override
                    public void run() {
                        int number =50; // 에러가 안남 실수할 가능성이 있음음
                       System.out.println("number = " + number);
                    }
                });

        //그냥 접근이 가능하다
        test1Closures("Lambda Expressions toString() ",()-> {
            //int number =40; //컴파일 에러가남
            System.out.println("number = " + number);
        });


    }



    private static void test1Closures(final String name, final Runnable runnable) {
        System.out.println("Start "+name+" : ");
        runnable.run();
    }

}
