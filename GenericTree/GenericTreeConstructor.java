package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class GenericTreeConstructor {

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static void main(String[] args) {
        Node root;
         int[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        Stack<Node> stack = new Stack<>();

        for (int i=0 ; i<array.length ; i++){
            if (array[i]==-1){
                stack.pop();
            } else {
                Node temp = new Node();
                temp.data = array[i];

                if (stack.size()>0) {
                    Node peek = stack.peek();
                    peek.children.add(temp);
                } else {
                    root = temp;
                }
                stack.push(temp);
            }
        }
    }
}
