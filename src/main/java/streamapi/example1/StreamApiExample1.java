package streamapi.example1;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApiExample1 {
    public static void main(String[] args) {

        IntStream.rangeClosed(0,10).forEach(i-> System.out.println("i = " + i));

        /**
         * iterate
         * seed -> 첫번쨰값
         * i->i+1 -> function i->값은 이전의 값을 말함
         *
         * foreach는 iterate에 거친 값들을 하나씩 받아서 출력시킴
         * */
        IntStream.iterate(1,i->i+1)
                .forEach(i-> System.out.print("i = " + i));


        Stream.iterate(BigInteger.ONE, i->i.add(BigInteger.ONE))
                .forEach(i-> System.out.print("i = " + i));
    }
}
