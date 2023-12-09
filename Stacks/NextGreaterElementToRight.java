package Stacks;

import java.util.Stack;

public class NextGreaterElementToRight {

    public static int[] nextGreaterElement(int[] array) {
        int[] answer = new int[array.length];
        Stack<Integer> st = new Stack<>();
        st.push(array[array.length-1]);
        answer[array.length-1] = -1;
        for (int i=array.length-2 ; i>=0 ; i--) {
            while (st.size() > 0 && array[i] > st.peek()) {
                st.pop();
            }
            if (st.size()==0) {
                answer[i] = -1;
            } else {
                answer[i] = st.peek();
            }
            st.push(array[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nextGreater = nextGreaterElement(new int[]{2, 5, 4, 10, 1, 12, 6, 8, 7});
        for (int a : nextGreater){
            System.out.print(a + " ");
        }
    }
}
