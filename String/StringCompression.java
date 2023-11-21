package String;

/**
 * @author - rohit
 * @project - Data-Structures-and-Algorithm-in-Java
 * @package - String
 * @created_on - 18 October-2023
 */

public class StringCompression {

    public static String compress(String str) {
        String a = str.charAt(0) + "";
        for (int i=1 ; i<str.length() ; i++) {
            char current = str.charAt(i);
            char previous = str.charAt(i-1);
            if (current != previous) {
                a+= current;
            }
        }
        return a;
    }

    public static String compression(String str) {
        String a = str.charAt(0) + "";
        int count = 1;
        for (int i=1 ; i<str.length() ; i++) {
            char current = str.charAt(i);
            char previous = str.charAt(i - 1);
            if (current == previous) count++;
            else {
                if (count > 1) {
                    a+= count;
                    count = 1;
                }
                a+= current;
            }
        }
        if (count > 1) {
            a+= count;
            count = 1;
        }
        return a;
    }

    public static void main(String[] args) {
        // aaabbcccddaeef
        System.out.println(compression("aaabbcccddaeef"));
    }
}
