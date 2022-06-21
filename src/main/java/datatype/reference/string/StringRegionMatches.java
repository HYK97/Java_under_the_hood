package datatype.reference.string;

public class StringRegionMatches {

    public static void main(String[] args) {
        //array - >    0 1 2 3 4 5 6 7
        String test = "테스트용 텍스트";
        String find = "스";
        String find2 = " ";
        String find3 = " 텍";
        boolean testOne = test.regionMatches(2, find, 0, 1);//false;
        System.out.println("testOne = " + testOne);
        boolean testTwo = test.regionMatches(1, find, 0, 1);//true;
        System.out.println("testTwo = " + testTwo);
        boolean testThree = test.regionMatches(4, find2, 0, 1);//true;
        System.out.println("testThree = " + testThree);
        boolean testFour = test.regionMatches(4, find3, 0, 2);//true;
        System.out.println("testFour = " + testFour);
    }
}
