package customfunctioninterface.identity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class identity {
    public static void main(String[] args) {

        final List<Integer> numbers = Arrays.asList(1,2,3,4,5);



        System.out.println(mapOld(numbers,i->i*2));
        System.out.println(mapOld(numbers,null));

        /**
         * identity 메서드사용한것
         * identity 메서드의 사용처 function interface는 리턴타입과 매개변수타입은 달라야하는데 이를 하려면 사용자가
         * null체크를 하면서 구현해야하는데 이렇게하면 코드가 지저분해지기 때문에 이럴때 identity 메서드를 사용하면 깔끔하게 해결할 수 있다.
         * */
        System.out.println(mapNew(numbers,i->i*2));
        System.out.println(mapOld(numbers,Function.identity()));
        System.out.println(mapOld(numbers,i->i));


    }

    private static <T,R> List<R> mapNew(final List<T> list, final Function<T,R> mapper) {

        final List<R> result= new ArrayList<>();

        for (final T t : list) {
            result.add(mapper.apply(t));
        }
        return result;

    }

    private static <T,R> List<R> mapOld(final List<T> list,final Function<T,R> mapper) {
        final List<R> result;
        if (mapper != null) {
            result = new ArrayList<>();
        } else {
            return new ArrayList<>((List<R>)list);
        }
        for (final T t : list) {
            result.add(mapper.apply(t));
        }
        return result;
    }
}

