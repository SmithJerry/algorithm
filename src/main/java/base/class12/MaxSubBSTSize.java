package base.class12;

import java.util.ArrayList;

/**
 * @author Liang
 * @date 2023/6/16 - 14:22
 */
public class MaxSubBSTSize {
    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    /**
     * 省略是否为搜索树的原因，如果为搜索树，节点总数与子树为搜索树的节点相等
     */
    public static class Info{
        public int maxBSTSubTreeSize;
        public int allSize;
        public int max;
        public int min;

        public Info(int maxBSTSubTreeSize, int allSize, int max, int min){
            this.maxBSTSubTreeSize = maxBSTSubTreeSize;
            this.allSize = allSize;
            this.max = max;
            this.min = min;
        }
    }

    public static int largestBSTSubTree(TreeNode head){
        if(head == null){
            return 0;
        }
        return process(head).maxBSTSubTreeSize;
    }

    public static Info process(TreeNode cur){
        if(cur == null){
            return null;
        }
        Info left = process(cur.left);
        Info right = process(cur.right);
        int max = cur.val;
        int min = cur.val;
        int allSize = 1;
        if(left != null){
            max = Math.max(left.max, max);
            min = Math.min(left.min, min);
            allSize += left.allSize;
        }

        if(right != null){
            max = Math.max(right.max, max);
            min = Math.min(right.min, min);
            allSize += right.allSize;
        }
        int p1 = -1;
        if(left != null){
            p1 = left.maxBSTSubTreeSize;
        }

        int p2 = -1;
        if(right != null){
            p2 = right.maxBSTSubTreeSize;
        }

        int p3 = -1;
        // 如果为搜索树，节点总数与子树为搜索树的节点相等
        boolean leftBST = left == null ? true : (left.maxBSTSubTreeSize == left.allSize);
        boolean rightBST = right == null ? true : (right.maxBSTSubTreeSize == right.allSize);
        if(leftBST && rightBST){
            boolean leftMaxLessX = left == null ? true : left.max < cur.val;
            boolean rightMinMoreX = right == null ? true : right.min > cur.val;
            if(leftMaxLessX && rightMinMoreX){
                int leftSize = left == null ? 0 : left.allSize;
                int rightSize = right == null ? 0 : right.allSize;
                p3 = leftSize + rightSize + 1;
            }
        }

        return new Info(Math.max(Math.max(p1, p2), p3), allSize, max, min);
    }

    // 为了验证
    // 对数器方法
    public static int right(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int h = getBSTSize(head);
        if (h != 0) {
            return h;
        }
        return Math.max(right(head.left), right(head.right));
    }

    // 为了验证
    // 对数器方法
    public static int getBSTSize(TreeNode head) {
        if (head == null) {
            return 0;
        }
        ArrayList<TreeNode> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).val <= arr.get(i - 1).val) {
                return 0;
            }
        }
        return arr.size();
    }

    // 为了验证
    // 对数器方法
    public static void in(TreeNode head, ArrayList<TreeNode> arr) {
        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

    // 为了验证
    // 对数器方法
    public static TreeNode generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // 为了验证
    // 对数器方法
    public static TreeNode generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        TreeNode head = new TreeNode((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    // 为了验证
    // 对数器方法
    public static void main(String[] args) {
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = generateRandomBST(maxLevel, maxValue);
            if (largestBSTSubTree(head) != right(head)) {
                System.out.println("出错了！");
            }
        }
        System.out.println("测试结束");
    }
}
