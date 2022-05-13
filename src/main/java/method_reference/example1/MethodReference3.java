package method_reference.example1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MethodReference3 {
    public static void main(String[] args) {
        methodReference();
    }

    private static void methodReference() {
        /*First Class Function*/
        /**
         * 파라매터에 사용될 수 있는가?
         * */
        //lambda 사용
        System.out.println("result Lambda = "+testFirstClassFunction1(i -> String.valueOf(i * 2),3));
        //method reference 사용
        System.out.println("result MethodReference = " + testFirstClassFunction1(MethodReference3::doubleThenToString,3));
        System.out.println("\n ===================================\n");
        /**
         * 리턴될 수 있는가?
         * */
        //lambda 사용
        final Function<Integer, String> lambda = getDoubleThenToStringUsingLambdaExpression();
        final String result = lambda.apply(3);
        System.out.println("result Lambda = " + result);
        //method reference 사용
        final Function<Integer, String> methodReference = getDoubleThenToStringUsingMethodReference();
        final String result2 =methodReference.apply(3);
        System.out.println("result MethodReference = " + result2);
        System.out.println("\n ===================================\n");
        /**
         * 변수에 저장할 수 있는가 ?
         * data structure에 저장할 수 있는가?
         * */
        //lambda 사용
        final List<Function<Integer, String>> fList= Arrays.asList(i -> String.valueOf(i * 2));
        for (Function<Integer, String> f : fList) {
            final String result3 = f.apply(3);
            System.out.println("result Lambda = " + result3);
        }
        //method reference 사용
        final List<Function<Integer, String>> fList2= Arrays.asList(MethodReference3::doubleThenToString);
        for (Function<Integer, String> f : fList2) {
            final String result4 = f.apply(3);
            System.out.println("result MethodReference = " + result4);
        }
        //lambda 사용
        final Function<Integer, String> f1 = i -> String.valueOf(i * 2);
        String result5 = f1.apply(3);
        System.out.println("result Lambda = " + result5);

        //method reference 사용
        final Function<Integer, String> f2 = MethodReference3::doubleThenToString;
        String result6 = f1.apply(3);
        System.out.println("result MethodReference = " + result5);

        /**
         * Lambda , MethodReference 동시사용
         * */
        final List<Function<Integer, String>> f3= Arrays.asList(i-> String.valueOf(i * 2),MethodReference3::doubleThenToString);
        for (Function<Integer, String> f : f3) {
            final String result7 = f.apply(3);
            System.out.println("result Both = " + result7);
        }

    }


    private static Function<Integer, String> getDoubleThenToStringUsingLambdaExpression() {
        return i -> String.valueOf(i * 2);
    }
    private static Function<Integer, String> getDoubleThenToStringUsingMethodReference() {
        return MethodReference3::doubleThenToString;
    }
    private static String doubleThenToString(int n) {
        return String.valueOf(n*2);
    }
    private static String testFirstClassFunction1(Function<Integer, String >f,int n) {
        return "result =" + f.apply(n);
    }

}
