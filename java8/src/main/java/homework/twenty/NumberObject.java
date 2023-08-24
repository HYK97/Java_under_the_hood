package homework.twenty;

public class NumberObject {
    public static void main(String[] args) {
        NumberObject obj = new NumberObject();
        long test1 = obj.parseLong("r1024");
        long test2 = obj.parseLong("1024");
        System.out.println("test1 = " + test1);
        System.out.println("test2 = " + test2);
        obj.printOtherBase(test2);
    }

    public long parseLong(String data) {

        long parse = 0;

        try {
            parse = Long.parseLong(data);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println(data + " is not a number.");
            return -1;
        }
        return parse;
    }

    public void printOtherBase(long value) {
        System.out.println("Original : " + value);
        System.out.println("Binary : " + Long.toBinaryString(value));
        System.out.println("HEX : " + Long.toHexString(value));
        System.out.println("Octal " + Long.toOctalString(value));
    }


}
