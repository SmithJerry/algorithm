package base.class12;

import base.class06.Heap;

/**
 * @author Liang
 * @date 2023/6/16 - 0:01
 *  平衡二叉树
 *  叶节点高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树
 */
public class IsBalanced {
    public static class Node{
        public int val;
        public Node left;
        public Node right;

        public Node(int val){
            this.val = val;
        }

        public static boolean isBalanced1(Node head){
            boolean[] ans = new boolean[1];
            ans[0] = true;
            function(head, ans);
            return ans[0];
        }

        private static int function(Node head, boolean[] ans) {

            if(!ans[0] || head == null){
                return -1;
            }

            int left = function(head.left, ans);
            int right = function(head.right, ans);
            if(Math.abs(left - right) > 1){
                ans[0] = false;
            }

            return Math.max(left, right) + 1;
        }

        public static class Info{
            public boolean isBalanced;
            public int height;

            public Info(boolean isBalanced, int height){
                this.isBalanced = isBalanced;
                this.height = height;
            }
        }

        public static boolean isBalanced2(Node head){
            if(head == null){
                return true;
            }
            return process(head).isBalanced;
        }

        public static Info process(Node cur){
            if(cur == null){
                return new Info(true, 0);
            }

            Info left = process(cur.left);
            Info right = process(cur.right);

            int height = Math.max(left.height, right.height) + 1;

            boolean isBalanced = true;
            if(!left.isBalanced || !right.isBalanced
            || (Math.abs(left.height - right.height) > 1)){
                isBalanced = false;
            }

            return new Info(isBalanced, height);
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
            for (int i = 0; i < testTimes; i++) {
                Node head = generateRandomBST(maxLevel, maxValue);
                if (isBalanced1(head) != isBalanced2(head)) {
                    System.out.println("Oops!");
                }
            }
            System.out.println("finish!");
        }
    }
}
