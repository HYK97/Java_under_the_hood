package generic_type_erasure;

import org.junit.jupiter.api.Test;

public class Run<T extends String> {

    public void print(T test) {
        System.out.println(test.toString());
    }

    @Test
    public void test() {
        //given
        Run<String> food = new Run<>();
        //when
        food.print("1");
        //    INVOKEVIRTUAL generic_type_erasure/Run.print (Ljava/lang/Object;)V - unbounded 일경우 Object로 치환
        //   INVOKEVIRTUAL generic_type_erasure/Run.print (Ljava/lang/String;)V  - String 으로 bounded 한경우 <T extends String>

        //then

    }
}
