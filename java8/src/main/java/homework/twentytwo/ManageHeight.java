package homework.twentytwo;

import java.util.ArrayList;
import java.util.List;

public class ManageHeight {
    private List<List<Integer>> gradeHeights = new ArrayList<>();

    public static void main(String[] args) {
        ManageHeight sample = new ManageHeight();
        sample.setData();
        for (int loop = 1; loop <= 5; loop++) {
            sample.printAverage(loop);
            sample.printHeight(loop);
        }
    }

    public void setData() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(170);
        list1.add(180);
        list1.add(173);
        list1.add(175);
        list1.add(177);

        List<Integer> list2 = new ArrayList<>();
        list2.add(160);
        list2.add(165);
        list2.add(167);
        list2.add(186);
        List<Integer> list3 = new ArrayList<Integer>();
        list3.add(158);
        list3.add(177);
        list3.add(187);
        list3.add(176);

        List<Integer> list4 = new ArrayList<Integer>();
        list4.add(173);
        list4.add(182);
        list4.add(181);

        List<Integer> list5 = new ArrayList<Integer>();
        list5.add(170);
        list5.add(180);
        list5.add(165);
        list5.add(177);
        list5.add(172);

        gradeHeights.add(list1);
        gradeHeights.add(list2);
        gradeHeights.add(list3);
        gradeHeights.add(list4);
        gradeHeights.add(list5);
    }

    public void printHeight(int classNo) {
        List<Integer> list = gradeHeights.get(classNo - 1);
        System.out.println(classNo + " 반");
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public void printAverage(int classNo) {
        double sum = 0;
        List<Integer> list = gradeHeights.get(classNo - 1);
        sum = list.stream().mapToInt(i -> i).sum();
        sum /= list.size();
        System.out.println("classNo " + classNo + " : " + sum);
    }
}
