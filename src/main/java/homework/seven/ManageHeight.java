package homework.seven;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.sun.deploy.uitoolkit.impl.awt.AWTClientPrintHelper.print;

public class ManageHeight {
    int[][] gradeHeights;

    public static void main(String[] args) {
        ManageHeight mh = new ManageHeight();
        mh.setData();
        for (int i = 0; i < 5; i++) {
            System.out.println("Class No.:" + (i + 1));
            mh.printHeight(i);
        }
        int j = 0;
        while (j < 5) {
            System.out.println("Class No.:" + (j + 1));
            mh.printAverage(j);
            j++;
        }


    }

    public void printHeight(int classNo) {
        int[] gradeHeight = gradeHeights[classNo];
        for (int i1 : gradeHeight) {
            System.out.println(i1);
        }

    }

    public void printAverage(int classNo) {
        int[] gradeHeight = gradeHeights[classNo];
        int sum = 0;
        for (int i1 : gradeHeight) {
            sum += i1;
        }
        double result = sum / gradeHeight.length;
        System.out.println("Height average : " + result);
    }

    public void setData() {
        this.gradeHeights = new int[][]{
                {170, 180, 173, 175, 177},
                {160, 165, 167, 186},
                {158, 177, 187, 176},
                {173, 182, 181},
                {170, 180, 165, 177, 172}};
    }
}
