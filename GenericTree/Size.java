package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class Size {

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node){
        StringBuilder stringBuilder = new StringBuilder(node.data + " -> ");
        for (Node child : node.children){
            stringBuilder.append(child.data).append(" , ");
        }
        System.out.println(stringBuilder);
        for (Node child : node.children){
            display(child);
        }
    }

    public static int size(Node node){
        int size = 0;
        for (Node child : node.children){
            int childSize = size(child);
            size += childSize;
        }
        size = size + 1;
        return size;
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = null;
        Stack<Node> stack = new Stack<>();
        for (int i=0 ; i<array.length ; i++){
            if (array[i]==-1){
                stack.pop();
            } else {
                Node temp = new Node();
                temp.data = array[i];
                if (stack.size()>0){
                    stack.peek().children.add(temp);
                } else{
                    root = temp;
                }
                stack.push(temp);
            }
        }
        System.out.println(size(root));
    }
}
