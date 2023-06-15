package base.class11;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Liang
 * @date 2023/6/14 - 23:42
 */
public class TreeMaxWidth {

    public static class Node{
        public int val;
        public Node left;
        public Node right;

        public Node(int val){
            this.val = val;
        }
    }

    public static int maxWidthUseMap(Node head){
        if(head == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        HashMap<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        int curLevel = 1;// 当前你正在统计哪一层的宽度
        int curLevelNodes = 0;// 当前层curLevel层，宽度目前是多少
        int max = 0;
        while (!queue.isEmpty()){
            Node cur = queue.poll();

            int curNodeLevel = levelMap.get(cur);
            if(cur.left != null){
                levelMap.put(cur.left, curNodeLevel + 1);
                queue.add(cur.left);
            }
            if(cur.right != null){
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }
            if(curNodeLevel == curLevel){
                curLevelNodes++;
            }else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
        }
        max = Math.max(max, curLevelNodes);
        return max;
    }

    public static int maxWidthNoMap(Node head){
        if(head == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node curEnd = head;// 当前层最右节点是谁
        Node nextEnd = null; // 下一层，最右节点是谁
        int max =0;
        int curLevelNodes = 0; // 当前层的节点数
        while (!queue.isEmpty()){
            Node node = queue.poll();
            if(node.left != null){
                queue.add(node.left);
                nextEnd = node.left;
            }
            if(node.right != null){
                queue.add(node.right);
                nextEnd = node.right;
            }
            curLevelNodes++;
            if(node == curEnd){
                max = Math.max(max, curLevelNodes);
                curLevelNodes = 0;
                curEnd = nextEnd;
            }
        }

        return max;
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
        int maxLevel = 10;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (maxWidthUseMap(head) != maxWidthNoMap(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");

    }
}
