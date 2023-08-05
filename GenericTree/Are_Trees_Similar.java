package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class Are_Trees_Similar {

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static boolean areSimilar(Node tree1, Node tree2){
        if (tree1.children.size()!=tree2.children.size())
            return false;
        for (int i=0 ; i<tree1.children.size() ; i++){
            Node tree1Node = tree1.children.get(i);
            Node tree2Node = tree2.children.get(i);
            if (!areSimilar(tree1Node, tree2Node)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = new Node();
        Stack<Node> stack = new Stack<>();
        for (int i : array){
            if (i==-1){
                stack.pop();
            } else {
                Node temp = new Node();
                temp.data = i;
                if (stack.size()>0){
                    stack.peek().children.add(temp);
                } else {
                    root = temp;
                }
                stack.push(temp);
            }
        }
        System.out.println(areSimilar(root, root));
    }
}
