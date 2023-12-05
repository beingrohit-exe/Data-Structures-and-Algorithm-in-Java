package Stacks;

import java.util.Stack;

public class DuplicateBrackets {

    /**
     * If there is duplicate brackets then print true
     * Else false
     * There is (,a,+ .... then push
     * For ) pop until it will not meet (
     * Once we pop the opening bracket then peek if there is open bracket then duplicate otherwise pop until next meet
     */
    public static void main(String[] args) {
        String data = "(1+2)+((4+5))"; // ((1+2) + (4+5))
        Stack<Character> st = new Stack<>();
        for (int i = 0 ; i<data.length() ; i++) {
            char ch = data.charAt(i);
            if (ch==')') {
                if (st.peek().equals('(')) {
                    System.out.println(true);
                } else {
                    while(st.peek()!='(') {
                        st.pop();
                    }
                    st.pop(); //For removing that bracket too
                }
            } else {
                st.push(ch);
            }
        }
        System.out.println(false);
    }
}
