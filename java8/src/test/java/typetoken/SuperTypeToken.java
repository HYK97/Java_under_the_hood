package typetoken;

import org.junit.jupiter.api.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SuperTypeToken {


    @Test
    public void typeSafeMap() {
        TypeSafeMap map = new TypeSafeMap();
        map.put(new TypeParameter<Integer>() {
        }, 1);
        map.put(new TypeParameter<String>() {
        }, "test");
        List<Integer> data = Arrays.asList(1, 3, 4, 5, 5);
        map.put(new TypeParameter<List<Integer>>() {
        }, data);
        List<String> data2 = Arrays.asList("s", "v");
        map.put(new TypeParameter<List<String>>() {
        }, data2);
        //이와 같이 제네릭 파라미터타입은 자바가 지원하지 않기때문에 super type token을 사용해야한다.
        //map.put(List<Integer>.class, Arrays.asList(1,3,4,5,5));

        assertThat(map.get(new TypeParameter<Integer>() {
        })).isEqualTo(1);
        assertThat(map.get(new TypeParameter<String>() {
        })).isEqualTo("test");
        assertThat(map.get(new TypeParameter<List<Integer>>() {
        })).isEqualTo(data);
        assertThat(map.get(new TypeParameter<List<String>>() {
        })).isEqualTo(data2);
    }

    @Test
    public void TypeParameter() {
        TypeParameter<List<String>> data = new TypeParameter<List<String>>() {
        };
        TypeParameter<String> data2 = new TypeParameter<String>() {
        };
        assertThat(data.type).isEqualTo(((ParameterizedType) data.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        assertThat(data2.type).isEqualTo(((ParameterizedType) data2.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);

        //assertThat(data.type).isInstanceOf()
    }


    @Test
    public void TypeParameterFalse() {
        assertThatThrownBy(() -> {
            TypeParameter<List<String>> data = new TypeParameter<List<String>>();
            //-> 다음과 같이 익명함수가 아닌 instance로 생성시에는 파라미터타입의 <List<String>>() 이것들은 타입 이레이저에 의해 지워지기 때문에 이타입의 원본을 유추할수없다.
        }).isInstanceOf(RuntimeException.class);
        //assertThat(data.type).isInstanceOf()
    }

    static class TypeSafeMap {
        Map<Type, Object> map = new HashMap<>();

        //generic을 이용해서 타입의 안전성을 더해줌
        <T> void put(TypeParameter<T> type, T data) {
            map.put(type.type, data);
        }

        //Class -> cast 를 이용해서 타입을 알아서 변환하도록 만듦.
        <T> T get(TypeParameter<T> type) {

            if (type.type instanceof Class<?>) {
                return ((Class<T>) type.type).cast(map.get(type.type));  //String  ,Integer 같은 타입
            } else {
                System.out.println("type = " + type.type);
                // List<Integer> 일경우 로우타입인 List ->로 변환해서 Casting 해야함
                System.out.println("type = " + ((ParameterizedType) type.type).getRawType());
                return ((Class<T>) ((ParameterizedType) type.type).getRawType()).cast(map.get(type.type));
            }

        }
    }

    static class TypeParameter<T> {
        Type type;

        public TypeParameter() {
            Type genericSuperclass = this.getClass().getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                this.type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            } else throw new RuntimeException("실행불가");
        }
    }


}
