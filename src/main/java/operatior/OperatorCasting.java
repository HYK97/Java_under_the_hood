package operatior;

public class OperatorCasting {
    public static void main(String[] args) {
        OperatorCasting op =new OperatorCasting();
        op.casting();
    }
    /**
     *
     *
     * */
    public void casting(){

        short sValue =256;
        System.out.println("256 sValue = " + sValue);
        System.out.println("256 sValue 이진수 = " + Integer.toBinaryString(sValue));
        byte bValue = (byte) sValue;
        System.out.println("256 bValue = " + bValue);
        System.out.println("256 bValue 이진수 = " + Integer.toBinaryString(bValue));

        sValue =255;
        System.out.println("255 sValue = " + sValue);
        System.out.println("255 sValue 이진수 = " + Integer.toBinaryString(sValue));
        bValue = (byte) sValue;
        System.out.println("255 bValue = " + bValue);
        System.out.println("255 bValue 이진수 = " + Integer.toBinaryString(bValue));

        bValue =0b11111111111111111111111110000000;
        System.out.println("bValue = " + bValue);



    }
}
