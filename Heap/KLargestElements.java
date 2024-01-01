package Heap;

import java.util.PriorityQueue;

public class KLargestElements {

    public static PriorityQueue<Integer> kthLargestElements(int[] array, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0 ; i<array.length ; i++) {
            if (i < k) {
                pq.add(array[i]);
            } else {
                if (pq.peek() < array[i]) {
                    pq.remove();
                    pq.add(array[i]);
                }
            }
        }
        return pq;
    }

    public static void main(String[] args) {
        int[] array = {2, 10, 5, 17, 7, 18, 6, 4};
        System.out.println(kthLargestElements(array, 4));
    }
}
