package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    //Like NextGreaterElementThanLeft
    //Pop all small elements
    public static void main(String[] args) {
        int[] ints = span(new int[]{2, 5, 9, 3, 1, 12, 6, 8, 7});
        Arrays.stream(ints).forEach(System.out::print);
    }

    public static int[] span(int[] array) {
        int[] span = new int[array.length];
        Stack<Integer> st = new Stack<>();
        st.push(0); // index
        span[0] = 1;
        for (int i=1 ; i<array.length ; i++) {
            while(st.size()>0 && array[i] > array[st.peek()]) {
                st.pop();
            }
            if (st.size()==0) {
                span[i] = i + 1;
            } else {
                span[i] = i - st.peek();
            }
            st.push(i);
        }
        return span;
    }
}
