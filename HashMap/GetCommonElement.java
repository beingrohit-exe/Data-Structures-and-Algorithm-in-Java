package HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GetCommonElement {

    public static void process(int[] a1, int[] a2) {
        HashMap<Integer, Integer> charFrequencyMap = new HashMap<>();
        for (int i=0 ; i<a1.length ; i++) {
            charFrequencyMap.put(a1[i], charFrequencyMap.getOrDefault(a1[i], 0) + 1);
        }
        for (int data : a2) {
            if (charFrequencyMap.containsKey(data)) {
                System.out.print(data + " ");
                charFrequencyMap.remove(data);
            }
        }
    }

    public static void processStream(int[] a1, int[] a2) {
        Map<Integer, Long> charFrequencyMap = Arrays
                .stream(a1)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Arrays
                .stream(a2)
                .filter(charFrequencyMap::containsKey)
                .peek(System.out::println)
                .forEach(charFrequencyMap::remove);
    }

    public static void main(String[] args) {
        int[] a1 = {1, 1, 2, 2, 2, 3, 5};
        int[] a2 = {1, 1, 1, 2, 2, 4, 5};
        process(a1, a2);
        processStream(a1, a2);
    }
}
