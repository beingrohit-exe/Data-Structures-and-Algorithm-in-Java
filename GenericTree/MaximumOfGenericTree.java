package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class MaximumOfGenericTree {

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node){
        String str = node.data + " -> ";
        for (Node child : node.children){
            str += child.data + " , ";
        }
        str += ".";
        System.out.println(str);
        for (Node child : node.children){
            display(child);
        }
    }

    public static int size(Node node){
        int size = 0;
        for (Node child : node.children){
            int size1 = size(child);
            size += size1;
        }
        size = size + 1;
        return size;
    }

    public static int max(Node node){
        int max = Integer.MIN_VALUE;
        for (Node child : node.children){
            int childMax = max(child);
            max = Math.max(childMax, max);
        }
        max = Math.max(node.data, max);
        return max;
    }
    public static void main(String[] args) {
        int[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = new Node();
        Stack<Node> stack = new Stack<>();
        for (int i=0 ; i<array.length ; i++){
            if (array[i]==-1){
                stack.pop();
            } else {
                Node temp = new Node();
                temp.data = array[i];
                if (stack.size()>0){
                    stack.peek().children.add(temp);
                } else {
                    temp = root;
                }
                stack.push(temp);
            }
        }
        System.out.println(max(root));
    }
}
