package company.test01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liang
 * @date 2023/9/7 - 9:08
 * 根据中序后序确定一个二叉树
 */
public class 已知中后序生成一个二叉树 {
    public static class Node{
        private int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
//        int[] arr = new int[]{4, 2, 5, 1, 6, 3, 7};
//        int[] arr = new int[]{9, 3, 15, 20, 7};
        int[] arr = new int[]{2, 1};
//        int[] post = new int[]{4, 5, 2, 6, 7, 3, 1};
//        int[] post = new int[]{9, 15, 7, 20, 3};
        int[] post = new int[]{2, 1};

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int num : arr){
            list1.add(num);
        }

        for(int num : post){
            list2.add(num);
        }

        int tmp = post[post.length - 1];
        Node root = new Node(tmp);

        process(list1, list2, root);
    }

    private static void process(List<Integer> list1, List<Integer> list2, Node root) {
        if(list1.size() == 1) {
//            root.left = new Node(list1.get(0));
            return;
        }
        if(list2.size() == 1){
//            root.right = new Node(list2.get(0));
            return;
        }

        int index = list1.indexOf(root.val);
        int right = list1.size() - index - 1;
        int left = index;
        if(left > 0){
            root.left = new Node(list2.get(list2.size() - right - 2));
            process(list1.subList(0, index), list2.subList(0, index), root.left);
        }

        if(right > 0){
            root.right = new Node(list2.get(list2.indexOf(root.val) - 1));
            process(list1.subList(index + 1, list1.size()), list2.subList(index, list2.size() - 1), root.right);
        }

    }
}
