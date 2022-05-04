package streamapi.example2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;


public class StreamApiMapFilter {
    public static void main(String[] args) {

        /**
         * For,if와 Stream의 차이점 확인
         * */

        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer result = null;
        int operationCount = 0;

        //3보다 크고 9보다 작은 수를 2배씩
        for (final Integer integer : numbers) {
            operationCount++;
            if (integer > 3 && integer < 9) {
                operationCount++;
                final Integer multi = integer * 2;
                if (multi > 10) {
                    operationCount++;
                    result = multi;
                    break;
                }
            }
        }

        System.out.println("for문이 사용한 오퍼 수 : " + operationCount);
        System.out.println("for문을 이용한 result = " + result);

        //Stream의 filter , map 를 이용한 result

        final AtomicInteger operationCount2 = new AtomicInteger(0);
        Optional<Integer> FunctionalResult = numbers.stream()
                .filter((n) -> {
                    operationCount2.getAndAdd(1);
                    return n > 3 && n < 9;
                })
                .map((n) -> {
                    operationCount2.getAndAdd(1);
                    return n * 2;
                })
                .filter(n -> {
                    operationCount2.getAndAdd(1);
                    return n > 10;
                })
                .findFirst();

        System.out.println("stream이 사용한 오퍼수 : " + operationCount2);

        //기본값 0
        System.out.println("Stream을 이용한  result = " + FunctionalResult.orElse(0));


    }
}
