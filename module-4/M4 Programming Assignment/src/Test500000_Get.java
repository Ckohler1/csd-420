/*
Colton Kohler
4/6/2025
M3: Programming Assignment

This program tests traversal of a LinkedList with 500,000 elements using get(index).
*/

import java.util.LinkedList;

public class Test500000_Get {
    public static void main(String[] args) {
        LinkedList<Integer> list = createLinkedList(500000);

        System.out.println("Testing get(index) traversal with 500,000 elements:");

        long start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        long end = System.currentTimeMillis();

        System.out.println("get(index) traversal time: " + (end - start) + " ms");
    }

    public static LinkedList<Integer> createLinkedList(int size) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }
}
/*
Results and Discussion:

For 50,000 elements:
- Using get(index), traversal took 970 ms.
- Using an Iterator, traversal took only 3 ms.
- The Iterator was much faster because get(index) in a LinkedList is very slow. Each get(index) call has to start from the beginning and walk through the list to find the right node.

For 500,000 elements:
- Using get(index) took an extremely long time (187,936 ms), making it feel like the IDE was broken.
- Using an Iterator took only 9 ms.
- The difference became even more extreme with 500,000 elements because LinkedList is not good for random access. The time for get(index) grows very fast as the list gets bigger.

Conclusion:
Using an Iterator is much faster than using get(index) to traverse a LinkedList, especially as the number of elements increases. LinkedList is designed for fast sequential access, not random access.
*/
