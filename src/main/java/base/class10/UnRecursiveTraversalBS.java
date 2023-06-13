package base.class10;

import java.util.Stack;

/**
 * @author Liang
 * @date 2023/6/12 - 23:35
 */
public class UnRecursiveTraversalBS {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public static void pre(Node head){

        System.out.println("pre-order:");
        if(head != null){
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                System.out.print(head.value);
                if(head.right != null){
                    stack.push(head.right);
                }
                if(head.left != null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    public static void in(Node head){
        System.out.println("in-order：");
        if(head != null){
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    public static void post1(Node head){

        System.out.print("post-order: ");

        if(head != null){
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()){
                head = s1.pop();
                s2.push(head);
                if(head.left != null){
                    s1.push(head.left);
                }
                if(head.right != null){
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()){
                System.out.print(s2.pop().value + " ");
            }

        }
        System.out.println();
    }
    public static void post2(Node head){

        System.out.print("post-order: ");

        if(head != null){
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            Node cur = null;
            while (!stack.isEmpty()){
                cur = stack.peek();
                if(cur.left != null && head != cur.left && head != cur.right){
                    stack.push(cur.left);
                }else if(cur.right != null && head != cur.right){
                    stack.push(cur.right);
                }else {
                    System.out.print(stack.pop().value + " ");
                    head = cur;
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        pre(head);
        System.out.println("========");
        in(head);
        System.out.println("========");
        post1(head);
        System.out.println("========");
        post2(head);
        System.out.println("========");
    }
}
