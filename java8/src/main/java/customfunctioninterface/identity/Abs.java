package customfunctioninterface.identity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Abs {
    public static void main(String[] args) {

        final int abs1 = Math.abs(-1);
        final int abs2 = Math.abs(1);

        System.out.println("abs1 = " + abs1);
        System.out.println("abs2 = " + abs2);
        System.out.println("(abs1==abs2) = " + (abs1==abs2));


        //자바의 Integer 가 unsigned int 가존재 하지않고 signed int임
        //즉 MaxValue가 0을포함해서 1이 작기때문에 절대값이 MinValue는 존재하지 않기 때문에 결국 Abs 함수는 함수형 프로그래밍에 해당할 수 없다.
        final int minInt= Math.abs(Integer.MIN_VALUE);
        System.out.println("minInt = " + minInt);


    }

}
