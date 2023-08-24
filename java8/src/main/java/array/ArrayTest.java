package array;

public class ArrayTest {
    public static void main(String[] args) {
        int [][] data =new int[2][3];
        System.out.println("data.length = " + data.length);

        System.out.println("data[0].length = " + data[0].length);
        data[0]= new int[]{1, 2, 3};
        data[1]= new int[]{4, 5, 6};


        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.println("data[i][j] = " + data[i][j]);
            }
        }

        for (int[] datum : data) {
            for (int i : datum) {
                System.out.println("i = " + i);
            }
        }

    }
}
