package homework.fourteen;

import java.util.Calendar;

public class Calculator {
    public static void main(String[] args) {
        Calculator calc=new Calculator();

        try {
            calc.printDivide(1,2);
            calc.printDivide(1,0);
        } catch (IllegalArgumentException e) {
            System.out.println("e.toString() = " + e.toString());
            e.printStackTrace();
        }
    }
    public void printDivide(double d1,double d2) throws IllegalArgumentException{
        if (d2 == 0) {
            throw new IllegalArgumentException("0이 올 수 없습니다");
        }
        double result =d1/d2;
        System.out.println("result = " + result);
    }
}
