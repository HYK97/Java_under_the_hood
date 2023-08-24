package javacollection;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> link = new LinkedList<>();
        link.add(1);
        link.add(2);
        link.add(3);
        System.out.println("link.listIterator().next() = " + link.listIterator().next());
        System.out.println("link.listIterator(0).next() = " + link.listIterator(0).next());
        System.out.println("link.listIterator(1).next() = " + link.listIterator(1).next());
        System.out.println("link.listIterator(2).hasNext() = " + link.listIterator(2).hasNext());
        System.out.println("link.listIterator(3).hasNext() = " + link.listIterator(3).hasNext());
        System.out.println("link.listIterator(2).hasNext() = " + link.listIterator(2).next());
        System.out.println("link.descendingIterator().next() = " + link.descendingIterator().next());
        System.out.println("link = " + link.remove(0));
        ListIterator<Integer> integerListIterator = link.listIterator();
        while (integerListIterator.hasNext()) {
            System.out.println(integerListIterator.next());
        }

    }
}
