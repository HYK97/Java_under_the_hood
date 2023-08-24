package homework.twentyone;

public class MaxFinder {
    public static void main(String[] args) {
        MaxFinder test = new MaxFinder();
        System.out.println("==============================Max");
        test.testGetMax();
        System.out.println("==============================Min");
        test.testGetMin();
    }

    public void testGetMax() {
        System.out.println(getMax(1, 2, 3));
        System.out.println(getMax(3, 2, 1));
        System.out.println(getMax(2, 3, 1));
        System.out.println(getMax("a", "b", "c"));
        System.out.println(getMax("b", "c", "a"));
        System.out.println(getMax("a", "b", "c"));
    }

    public void testGetMin() {
        System.out.println(getMin(1, 2, 3));
        System.out.println(getMin(3, 2, 1));
        System.out.println(getMin(2, 3, 1));
        System.out.println(getMin("a", "b", "c"));
        System.out.println(getMin("b", "c", "a"));
        System.out.println(getMin("a", "b", "c"));
    }

    private <T extends Comparable<T>> T getMin(T... a) {
        T min = a[0];
        for (T t : a) {
            if (t.compareTo(min) < 0) {
                min = t;
            }
        }
        return min;
    }

    private <T extends Comparable<T>> T getMax(T... a) {
        T max = a[0];
        for (T t : a) {
            if (t.compareTo(max) > 0) {
                max = t;
            }
        }
        return max;
    }


}
