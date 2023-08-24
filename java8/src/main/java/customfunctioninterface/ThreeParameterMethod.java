package customfunctioninterface;

/**
 *
 * 3가지의 파라미미를 받는 CustomFunctionalInterFace
 *
 * @param <T1>
 * @param <T2>
 * @param <T3>
 * @param <R>
 */
@FunctionalInterface
public interface ThreeParameterMethod <T1,T2,T3,R>{
    R start(T1 t1,T2 t2,T3 t3);


}
