package HashMap;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Data-Structures-and-Algorithm-in-Java
 * Package - HashMap
 * Created_on - 22 November-2023
 * Created_at - 12 : 08
 */

public class CommonIntersectionOfArrays {

    public static void doProcess(int[] a1, int[] a2) {
        Map<Integer, Long> charFrequencyMap = Arrays
                .stream(a1)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (int data : a2) {
            if (charFrequencyMap.containsKey(data)) {
                Long frequency = charFrequencyMap.get(data);
                if (frequency > 0) {
                    System.out.print(data + " ");
                    charFrequencyMap.put(data, frequency-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a1 = {1, 1, 2, 2, 2, 3, 5};
        int[] a2 = {1, 1, 1, 2, 2, 4, 5};
        doProcess(a1, a2);
    }
}
