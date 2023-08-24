package effective_java.item2.privateconstructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//상속불가능
//public class Child extends PrivateConstructorUtils {
public class Child {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //생성불가능
        //PrivateConstructorUtils pri =new PrivateConstructorUtils();

        /**
         * 다음과같이 리플렉션을 이용해서 생성자를 강제생성하려고하면 예외를 반환하도록 처리한다.
         * */
        Constructor<PrivateConstructorUtils> constructor = PrivateConstructorUtils.class.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        PrivateConstructorUtils privateConstructorUtils = constructor.newInstance();
        System.out.println("privateConstructorUtils = " + privateConstructorUtils);

    }
}
