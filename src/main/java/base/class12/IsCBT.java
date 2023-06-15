package base.class12;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Liang
 * @date 2023/6/15 - 0:11
 */
public class IsCBT {
    public static class Node{
        public int val;
        public Node left;
        public Node right;

        public Node(int val){
            this.val = val;
        }
    }
    public static boolean isCBT1(Node head){
        if(head == null){
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.add(head);
        // 是否遇到左右两个孩子不爽全的情况
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            l = cur.left;
            r = cur.right;
            if((leaf && (l != null || r != null))
                    || (l == null && r != null)){
                return false;
            }
            if(l != null){
                queue.add(l);
            }
            if(r != null){
                queue.add(r);
            }
            if(l == null || r == null){
                leaf = true;
            }
        }
        return true;
    }

    public static class Info{
        public boolean isFull;
        public boolean isCBT;
        public int height;

        public Info(boolean isFull, boolean isCBT, int height){
            this.isFull = isFull;
            this.isCBT = isCBT;
            this.height = height;
        }
    }

    public static boolean isCBT2(Node head){
        if(head == null){
            return true;
        }
        return process(head).isCBT;
    }
    public static Info process(Node cur){
        if(cur == null){
            return new Info(true, true, 0);
        }
        Info left = process(cur.left);
        Info right = process(cur.right);
        int height = Math.max(left.height, right.height) + 1;
        boolean isFull = left.isFull && right.isFull && left.height == right.height;

        boolean isCBT = false;
        if(isFull){
            isCBT = true;
        }else {
            if(left.isFull && right.isFull && left.height == right.height + 1){
                isCBT = true;
            }
            if(left.isCBT && right.isFull && left.height == right.height + 1){
                isCBT = true;
            }
            if(left.isFull && right.isCBT && left.height == right.height){
                isCBT = true;
            }
        }


        return new Info(isFull, isCBT, height);
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
            if (isCBT1(head) != isCBT2(head)) {
                System.out.println("f1:" + isCBT1(head));
                System.out.println("f2:" + isCBT2(head));
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }

}
