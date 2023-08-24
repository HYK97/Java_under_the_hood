package homework.twentyfour;

import java.util.Hashtable;
import java.util.Random;

public class RandomNumberStatistics {
    private final int DATA_BOUNDARY = 50;
    private Hashtable<Integer, Integer> hashTable = new Hashtable<>();

    public static void main(String[] args) {
        RandomNumberStatistics test = new RandomNumberStatistics();
        test.getRandomNumberStatistics();
    }

    public void getRandomNumberStatistics() {
        Random random = new Random();
        for (int i = 0; i < 5000; i++) {
            putCurrentRandomNumber(random.nextInt(DATA_BOUNDARY));
        }
        printStatistics();
        countAllData();
    }

    public void printStatistics() {
        for (Integer key : hashTable.keySet()) {
            if (key % 10 - 1 == 0) {
                System.out.println();
            }
            System.out.print(key + " = " + hashTable.get(key) + "  ");
        }
    }

    public void countAllData() {
        int count = 0;
        for (Integer key : hashTable.keySet()) {
            count += hashTable.get(key);
        }
        System.out.println("count = " + count);
    }

    public void putCurrentRandomNumber(int tempNumber) {
        if (!hashTable.containsKey(tempNumber)) {
            hashTable.put(tempNumber, 1);
        } else {
            hashTable.put(tempNumber, hashTable.get(tempNumber) + 1);
        }

    }
}
