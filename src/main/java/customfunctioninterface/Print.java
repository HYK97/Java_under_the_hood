package customfunctioninterface;

import java.util.function.BiFunction;

public class Print {

    /**
     *
     * String 방식 프린터
     *
     * @param t1
     * @param t2
     * @param t3
     * @param function
     * @param <T1>
     * @param <T2>
     * @param <T3>
     * @param <R> 리턴타입 String 지정
     * @return
     */

    public <T1,T2,T3> String stringPrinter(T1 t1, T2 t2,T3 t3,ThreeParameterMethod<T1,T2,T3,String> function) {
        return function.start(t1,t2,t3);
    }

    /**
     *
     * 자율 방식 프린터
     *
     * @param t1
     * @param t2
     * @param t3
     * @param function
     * @param <T1>
     * @param <T2>
     * @param <T3>
     * @param <R>
     * @return
     */
    public <T1,T2,T3,R> R freePrinter(T1 t1, T2 t2,T3 t3,ThreeParameterMethod<T1,T2,T3,R> function) {
        return function.start(t1,t2,t3);
    }


    /**
     *
     * 2개의 파라미터를 받는 자율 방식 프린터
     * @param t1
     * @param t2
     * @param function
     * @param <T1>
     * @param <T2>
     * @param <R>
     * @return
     */
    public <T1,T2,R> R twoParametersPrinter(T1 t1, T2 t2, BiFunction<T1,T2,R> function) {
        return function.apply(t1,t2);
    }


    public String nonGenericString(String value, nonGenericFunctional function){
        return function.start(value);
    }

    public <T>String genericMethodString(T value, GenericMethodFunctional function){
        return function.<T>start(value);
    }
}
