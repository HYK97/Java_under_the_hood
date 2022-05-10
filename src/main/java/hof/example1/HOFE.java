package hof.example1;

import java.util.function.Function;

public class HOFE {
    public static void main(String[] args) {
        final Function<Function<Integer,String>,String> f = g -> g.apply(10);
        String result = f.apply(i -> String.valueOf("값은 ? " + i));
        System.out.println("result = " + result);

        final Function<Integer,Function<Integer,String>> f2 = g-> g2->String.valueOf("첫번째 : "+g +"/ 두번째 : "+g2);
        String result2 = f2.apply(10).apply(20);
        System.out.println("result2 = " + result2);

        final Function<Integer,Function<Integer,Function<Integer,String>>> f3 = i -> i2 -> i3 -> "값 : "+i+i2+i3;
        String result3 = f3.apply(1).apply(2).apply(3);
        System.out.println("result3  = " + result3);

    }
}
