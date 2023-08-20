package base.class12;

/**
 * @author Liang
 * @date 2023/6/16 - 15:19
 */
public class MaxDistance {
    public static class Node{
        public int val;
        public Node left;
        public Node right;

        public Node(int val){
            this.val = val;
        }
    }

    public static int maxDistance1(Node head){
        return 0;
    }

    public static class Info{
        public int maxDistance;
        public int height;

        public Info(int maxDistace, int height){
            this.maxDistance = maxDistace;
            this.height = height;
        }
    }

    public static int maxDistance2(Node head){
        return process(head).maxDistance;
    }

    public static Info process(Node cur){
        if(cur == null){
            return new Info(0, 0);
        }

        Info left = process(cur.left);
        Info right = process(cur.right);

        int height = Math.max(left.height, right.height) + 1;

        int p1 = left.maxDistance;
        int p2 = right.maxDistance;
        int p3 = left.height + right.height + 1;

        int maxDistance = Math.max(Math.max(p1, p2), p3);
        return new Info(maxDistance, height);
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
            if (maxDistance1(head) != maxDistance2(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }
}
