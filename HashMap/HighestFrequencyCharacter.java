package HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Data-Structures-and-Algorithm-in-Java
 * Package - HashMap
 * Created_on - 21 November-2023
 * Created_at - 23 : 51
 */

public class HighestFrequencyCharacter {

    public static char process(String data) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i=0 ; i<data.length() ; i++) {
            char ch = data.charAt(i);
            if (hashMap.containsKey(ch)) {
                hashMap.put(ch, hashMap.get(ch) + 1);
            } else {
                hashMap.put(ch, 1);
            }
        }
        char max = data.charAt(0);
        for (Character key : hashMap.keySet()) {
            if (hashMap.get(key) > hashMap.get(max)) {
                max = key;
            }
        }
        return max;
    }

    public static char processOptimized(String data) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char ch : data.toCharArray()) {
            charFrequencyMap.put(ch, charFrequencyMap.getOrDefault(ch, 0) + 1);
        }
        int maxFrequency = 0;
        char maxChar = data.charAt(0);

        for (Map.Entry<Character, Integer> entry : charFrequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                maxChar = entry.getKey();
            }
        }
        return maxChar;
    }

    public static char usingStreamApi(String data) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char ch : data.toCharArray()) {
            charFrequencyMap.put(ch, charFrequencyMap.getOrDefault(ch, 0) + 1);
        }
        Map.Entry<Character, Integer> maxEntry = charFrequencyMap
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);
        return (maxEntry!=null) ? maxEntry.getKey() : data.charAt(0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Line : ");
        String data = bufferedReader.readLine();
        System.out.println(process(data));
    }
}
