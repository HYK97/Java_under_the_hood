package datatype.reference.string;

public class StringContains {
    public static void main(String[] args) {
        String[] data = {"나는 사람이다", "너는 동물이다", "나는 바보다", "나는 천재다", "나는 중간 사람이다"};

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        for (String datum : data) {
            if (datum.startsWith("나는")) {
                count1++;
            }
            if (datum.endsWith("이다")) {
                count2++;
            }
            if (datum.endsWith("사람이다")) {
                count3++;
            }
            if (datum.endsWith("중간 사람이다")) {
                count4++;
            }
        }
        System.out.println("나는 count " + count1);
        System.out.println("이다 count " + count2);
        System.out.println("사람이다 count " + count3);
        System.out.println("중간 사람이다 count " + count4);

    }
}
