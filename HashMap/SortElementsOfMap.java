package HashMap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Data-Structures-and-Algorithm-in-Java
 * Package - HashMap
 * Created_on - 22 November-2023
 * Created_at - 00 : 24
 */

public class SortElementsOfMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Four", 4);
        map.put("Five", 5);
        System.out.println(map);
        Comparator<Map.Entry<String, Integer>> comparator = Map.Entry.comparingByValue();
        map
                .entrySet()
                .stream()
                .sorted(comparator)
                .forEach(entry -> {
                    System.out.println(entry.getKey() + " : " + entry.getValue());
                });
    }
}
