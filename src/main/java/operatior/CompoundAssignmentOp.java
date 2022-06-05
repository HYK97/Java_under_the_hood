package operatior;

public class CompoundAssignmentOp {

    public static void main(String[] args) {
        int intValue= 10;
        intValue +=5;
        System.out.println("intValue = " + intValue);
        intValue -=5;
        System.out.println("intValue = " + intValue);
        intValue *=5;
        System.out.println("intValue = " + intValue);
        intValue /=5;
        System.out.println("intValue = " + intValue);
        intValue %=5;
        System.out.println("intValue = " + intValue);
    }
}
