package base.class11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Liang
 * @date 2023/6/14 - 20:21
 * 序列化二叉树
 * 二叉树可以通过先序、后序或者按层遍历的方式序列化和反序列化，
 * 以下代码全部实现了。
 * 但是，二叉树无法通过中序遍历的方式实现序列化和反序列化
 * 因为不同的两棵树，可能得到同样的中序序列，即便补了空位置也可能一样。
 * 比如如下两棵树
 *         __2
 *        /
 *       1
 *       和
 *       1__
 *          \
 *           2
 * 补足空位置的中序遍历结果都是{ null, 1, null, 2, null}
 *
 * */
public class SerializerAndReconstructTree {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int value){
            this.value = value;
        }
    }

    public static Queue<String> preSerial(Node head){
        Queue<String> ans = new LinkedList<>();
        pres(head, ans);
        return ans;
    }

    private static void pres(Node head, Queue<String> ans) {
        if(head == null){
            ans.add(null);
        }else {
            ans.add(head.value + "");
            pres(head.left, ans);
            pres(head.right, ans);
        }
    }

    public static Queue<String> inSerial(Node head){
        Queue<String> ans = new LinkedList<>();
        ins(head, ans);
        return ans;
    }

    private static void ins(Node head, Queue<String> ans) {
        if(head == null){
            ans.add(null);
        }else {
            ins(head.left, ans);
            ans.add(head.value + "");
            ins(head.right, ans);
        }
    }

    public static Queue<String> postSerial(Node head){
        Queue<String> ans = new LinkedList<>();
        post(head, ans);
        return ans;
    }

    private static void post(Node head, Queue<String> ans) {
        if(head == null){
            ans.add(null);
        }else {
            post(head.left, ans);
            post(head.right, ans);
            ans.add(head.value + "");
        }
    }

    public static Node buildByPreQueue(Queue<String> preList){
        if(preList == null || preList.size() == 0){
            return null;
        }
        return preb(preList);
    }

    public static Node preb(Queue<String> preList) {
        String cur = preList.poll();
        if(cur == null){
            return null;
        }
        Node head = new Node(Integer.valueOf(cur));
        head.left = preb(preList);
        head.right = preb(preList);
        return head;
    }

    public static Node buildByPosrList(Queue<String> postList){
        if(postList == null || postList.size() == 0){
            return null;
        }
        Stack<String> stack = new Stack<>();
        while (!postList.isEmpty()){
            stack.push(postList.poll());
        }
        return postb(stack);
    }

    private static Node postb(Stack<String> stacks) {
        String poll = stacks.pop();
        if(poll == null){
            return null;
        }
        Node h = new Node(Integer.valueOf(poll));
        h.right = postb(stacks);
        h.left = postb(stacks);
        return h;
    }

    public static Queue<String> levelSerial(Node head){
        Queue<String> ans = new LinkedList<>();
        if(head == null){
            ans.add(null);
        }else {
            ans.add(head.value + "");
            Queue<Node> queue = new LinkedList<>();
            queue.add(head);
            while (!queue.isEmpty()){
                head = queue.poll();
                if(head.left != null){
                    ans.add(head.left.value + "");
                    queue.add(head.left);
                }else {
                    ans.add(null);
                }

                if(head.right != null){
                    ans.add(head.right.value + "");
                    queue.add(head.right);
                }else {
                    ans.add(null);
                }
            }
        }
        return ans;
    }

    public static Node buildByLevelQueue(Queue<String> levelList){
        if(levelList == null || levelList.size() == 0){
            return null;
        }
        Node head = generateNode(levelList.poll());
        Queue<Node> queue = new LinkedList<>();
        if(head != null){
            queue.add(head);
        }
        Node node = null;
        while (!queue.isEmpty()){
            node = queue.poll();
            node.left = generateNode(levelList.poll());
            node.right = generateNode(levelList.poll());
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return head;
    }

    private static Node generateNode(String poll) {

        if(poll == null){
            return null;
        }
        return new Node(Integer.valueOf(poll));
    }

    public static Node generateRandomBST(int maxLevel, int maxValue){
        return generate(1, maxLevel, maxValue);
    }

    private static Node generate(int level, int maxLevel, int maxValue) {
        if(level > maxLevel || Math.random() < 0.5){
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    // for test
    public static boolean isSameValueStructure(Node head1, Node head2) {
        if (head1 == null && head2 != null) {
            return false;
        }
        if (head1 != null && head2 == null) {
            return false;
        }
        if (head1 == null && head2 == null) {
            return true;
        }
        if (head1.value != head2.value) {
            return false;
        }
        return isSameValueStructure(head1.left, head2.left) && isSameValueStructure(head1.right, head2.right);
    }

    // for test
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000000;
        System.out.println("test begin");
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            Queue<String> pre = preSerial(head);
            Queue<String> pos = postSerial(head);
            Queue<String> level = levelSerial(head);
            Node preBuild = buildByPreQueue(pre);
            Node posBuild = buildByPosrList(pos);
            Node levelBuild = buildByLevelQueue(level);
            if (!isSameValueStructure(preBuild, posBuild) || !isSameValueStructure(posBuild, levelBuild)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test finish!");

    }

}
