package innerclass;

import java.util.Arrays;

public class AnonymousClassSample {
    public static void main(String[] args) {
        OutClass2<Integer> outClass2 = new OutClass2<>((i) -> Arrays.stream(i).mapToInt(j -> j).sum());
        outClass2.start(1, 2, 3, 4, 5, 6);
        OutClass2<Double> outClass = new OutClass2<>((i) -> Arrays.stream(i).mapToDouble(j -> j).sum());
        outClass.start(1.1, 100.201, 2030.321);
    }
}
