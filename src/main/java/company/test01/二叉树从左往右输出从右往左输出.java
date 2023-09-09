package company.test01;

import java.util.*;

/**
 * @author Liang
 * @date 2023/8/20 - 21:41
 */
public class 二叉树从左往右输出从右往左输出 {
    public static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int v){

        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        boolean flag = true;
        while(!queue.isEmpty()){
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(flag){
                    levelList.offerLast(cur.val);
                }else{
                    levelList.offerFirst(cur.val);
                }

                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
            ans.add(new LinkedList<Integer>(levelList));
            flag = !flag;
        }
        return ans;
    }

}
