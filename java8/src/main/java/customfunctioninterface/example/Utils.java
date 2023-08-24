package customfunctioninterface.example;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Utils {

    public <T> List<T> filter(List<T> list, Predicate<? super T> predicate){
        List<T> result = new ArrayList<T>();
        for(T t : list){
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    public <T,R> List<R> mapper(List<T> list,Function<T,R> function){
        List<R> result = new ArrayList<R>();
        for (T t : list) {
            result.add(function.apply(t));

        }
        return result;
    }

}
