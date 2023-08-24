package typetoken;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class TypeToken {

    @Test
    public void typeSafeMap() {
        TypeSafeMap map = new TypeSafeMap();
        map.put(Integer.class, 1);
        map.put(String.class, "test");
        List<Integer> data = Arrays.asList(1, 3, 4, 5, 5);
        map.put(List.class, data);
        //이와 같이 제네릭 파라미터타입은 자바가 지원하지 않기때문에 super type token을 사용해야한다.
        //map.put(List<Integer>.class, Arrays.asList(1,3,4,5,5));

        assertThat(map.get(Integer.class)).isEqualTo(1);
        assertThat(map.get(String.class)).isEqualTo("test");
        assertThat(map.get(List.class)).isEqualTo(data);
        //다음과 같이 list로 저장하면 기존의 데이터는 덮어씌워짐
        List<String> data2 = Arrays.asList("s", "v");
        map.put(List.class, data2);
        assertThat(map.get(List.class)).isNotEqualTo(data);
        assertThat(map.get(List.class)).isEqualTo(data2);
    }

    static class TypeSafeMap {
        Map<Class<?>, Object> map = new HashMap<>();

        //generic을 이용해서 타입의 안전성을 더해줌
        <T> void put(Class<T> clazz, T data) {
            map.put(clazz, data);
        }

        //Class -> cast 를 이용해서 타입을 알아서 변환하도록 만듦.
        <T> T get(Class<T> clazz) {
            return clazz.cast(map.get(clazz));
        }
    }


}
