package homework.twentythree;

import java.util.HashSet;
import java.util.Random;

public class RandomNumberMaker {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            HashSet<Integer> sixNumbers = getSixNumbers();
            System.out.println(sixNumbers);
        }
    }

    public static HashSet<Integer> getSixNumbers() {
        Random random = new Random();
        HashSet<Integer> set = new HashSet<>();
        while (set.size() < 6) {
            set.add(random.nextInt(45));
        }
        return set;
    }
}
