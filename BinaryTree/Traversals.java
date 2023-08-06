package BinaryTree;

import java.util.Stack;

public class Traversals {

    private static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    private static class Pair{
        int state;
        Node node;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }

    public static void traversalsPre(Node node){
        if (node==null)
            return;
        System.out.println(node.data + " ");
        traversalsPre(node.left);
        traversalsPre(node.right);
    }

    public static void traversalsIn(Node node){
        if (node==null)
            return;
        traversalsIn(node.left);
        System.out.println(node.data);
        traversalsIn(node.right);
    }

    public static void traversalsPost(Node node){
        if (node==null){
            return;
        }
        traversalsPost(node.left);
        traversalsPost(node.right);
        System.out.println(node.data);
    }
    public static void main(String[] args) {
        Integer[] array = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Stack<Pair> stack = new Stack<>();
        Node root = new Node(array[0]);
        Pair pair = new Pair(root, 1);
        stack.push(pair);
        int idx = 0;
        while(stack.size()>0){
            Pair top = stack.peek();
            if (top.state==1){
                idx++;
                if (array[idx]!=null){
                    Node leftNode = new Node(array[idx]);
                    top.node.left = leftNode;
                    Pair leftPair = new Pair(leftNode, 1);
                    stack.push(leftPair);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state==2){
                idx++;
                if (array[idx]!=null){
                    Node rightNode = new Node(array[idx]);
                    Pair rightPair = new Pair(rightNode, 1);
                    top.node.right = rightNode;
                    stack.push(rightPair);
                } else {
                    top.node.right = null;
                }
                top.state++;
            } else {
                stack.pop();
            }
        }
        traversalsPost(root);
    }
}
