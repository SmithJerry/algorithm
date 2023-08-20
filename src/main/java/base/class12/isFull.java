package base.class12;

import java.security.Permissions;

/**
 * @author Liang
 * @date 2023/6/16 - 0:17
 *
 * 左树和右树都为满二叉树且高度相等
 */
public class isFull {
    public static class Node{
        public int val;
        public Node left;
        public Node right;

        public Node(int val){
            this.val = val;
        }
    }

    public static class Info1 {
        public int height;
        public int nodes;

        public Info1(int h, int n) {
            height = h;
            nodes = n;
        }
    }

    public static boolean isFull1(Node head){
        if(head == null){
            return true;
        }

        Info1 all = function(head);
        return (1 << all.height) - 1 == all.nodes;
    }

    private static Info1 function(Node head) {
        if(head == null){
            return new Info1(0, 0);
        }
        Info1 left = function(head.left);
        Info1 right = function(head.right);

        int height = Math.max(left.height, right.height) + 1;
        int nodes = left.nodes + right.nodes + 1;

        return new Info1(height, nodes);
    }

    public static class Info{
        public boolean isFull;
        public int height;

        public Info(boolean isFull, int height){
            this.isFull = isFull;
            this.height = height;
        }
    }

    public static boolean isFull2(Node head){
        if(head == null){
            return true;
        }

        return process(head).isFull;
    }

    public static Info process(Node cur){
        if(cur == null){
            return new Info(true, 0);
        }

        Info left = process(cur.left);
        Info right = process(cur.right);

        boolean isFull = left.isFull && right.isFull && right.height == left.height;

        int height = Math.max(left.height, right.height) + 1;
        return new Info(isFull, height);
    }

    // for test
    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (isFull1(head) != isFull2(head)) {
                System.out.println("出错了!");
            }
        }
        System.out.println("测试结束");
    }
}
