package base.class11;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liang
 * @date 2023/6/14 - 21:20
 */
public class EncodeNaryTreeToBinaryTree {
    public static class Node{
        public int val;
        public List<Node> children;
        public Node(){

        }
        public Node(int val){
            this.val = val;
        }
        public Node(int val, List<Node> children){
            this.val = val;
            this.children = children;
        }
    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    public static TreeNode encode(Node root){
        if(root == null){
            return null;
        }
        TreeNode head = new TreeNode(root.val);
        head.left = en(root.children);
        return head;
    }

    private static TreeNode en(List<Node> children) {
        if(children == null || children.size() == 0){
            return null;
        }
        TreeNode head = null;
        TreeNode cur = null;
        for(Node child : children){
            TreeNode treeNode = new TreeNode(child.val);
            if(head == null){
                head = treeNode;
            }else {
                cur.right = treeNode;
            }

            cur = treeNode;
            cur.left = en(child.children);
        }
        return head;
    }

    public Node decode(TreeNode root){
        if(root == null){
            return null;
        }
        return new Node(root.val, de(root.left));
    }

    private List<Node> de(TreeNode root) {
        List<Node> children = new ArrayList<>();
        while (root != null){
            Node node = new Node(root.val, de(root.left));
            children.add(node);
            root = root.right;
        }
        return children;
    }
}

