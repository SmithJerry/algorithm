package base.class12;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

/**
 * @author Liang
 * @date 2023/6/15 - 23:28
 *  是否为二叉搜索树
 *  左树最大值小于X，右树最小值大于X
 */
public class IsBST {

    public static class Node{
        public int val;
        public Node left;
        public Node right;

        public Node(int val){
            this.val = val;
        }
    }

    public static boolean isBST1(Node head){
        if(head == null){
            return true;
        }

        List<Node> arr = new ArrayList<>();
        in(head, arr);
        for(int i = 1; i < arr.size(); i++){
            if(arr.get(i).val <= arr.get(i - 1).val){
                return false;
            }
        }
        return true;
    }

    public static void in(Node head, List<Node> arr){

        if(head == null){
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

    public static class Info{
        public boolean isBST;
        public int max;
        public int min;

        public Info(boolean isBST, int max, int min){
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

    public static boolean isBST2(Node head){
        if(head == null){
            return true;
        }
        return process(head).isBST;
    }

    public static Info process(Node cur){
        if(cur == null){
            return null;
        }

        Info left = process(cur.left);
        Info right = process(cur.right);

        boolean isBST = true;
        int max = cur.val;
        int min = cur.val;
        if(left != null){
            max = Math.max(left.max, max);
            min = Math.min(left.min, min);
        }
        if(right != null){
            max = Math.max(right.max, max);
            min = Math.min(right.min, min);
        }

        if(left != null && (!left.isBST || left.max >= cur.val)
                || right != null && (!right.isBST || right.min <= cur.val)){
            isBST = false;
        }

        return new Info(isBST, max, min);
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
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (isBST1(head) != isBST2(head)) {
                System.out.println("isBST1:" + isBST1(head));
                System.out.println("isBST2:" + isBST2(head));
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }
}
