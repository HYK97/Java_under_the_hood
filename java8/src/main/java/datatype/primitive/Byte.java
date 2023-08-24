package datatype.primitive;

public class Byte {
    public static void main(String[] args) {

        /**
         * -128 ~ 127
         * */
        byte byteLastNegative = 0b11111111111111111111111110000000;
        byte byteLastPositive  = 0b01111111;
        System.out.println("byteLastNegative = " + byteLastNegative);
        System.out.println("byteLastPositive = " + byteLastPositive);
    }
}
