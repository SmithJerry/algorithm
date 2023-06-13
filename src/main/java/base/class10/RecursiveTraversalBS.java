package base.class10;

/**
 * @author Liang
 * @date 2023/6/12 - 23:35
 */
public class RecursiveTraversalBS{
    public static class Node{
        public int value;
        public UnRecursiveTraversalBS.Node left;
        public UnRecursiveTraversalBS.Node right;

        public Node(int value){
            this.value = value;
        }
    }
    // 递归序
    public static void f(UnRecursiveTraversalBS.Node head){
        if(head == null){
            return;
        }

        f(head.left);
        f(head.right);
    }

    public static void pre(UnRecursiveTraversalBS.Node head){
        if(head == null){
            return;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    public static void in(UnRecursiveTraversalBS.Node head){
        if(head == null){
            return;
        }

        in(head.left);
        System.out.println(head.value);
        in(head.right);
    }

    public static void post(UnRecursiveTraversalBS.Node head){
        if(head == null){
            return;
        }

        post(head.left);
        post(head.right);
        System.out.println(head.value);
    }

    public static void main(String[] args) {
        UnRecursiveTraversalBS.Node head = new UnRecursiveTraversalBS.Node(1);
        head.left = new UnRecursiveTraversalBS.Node(2);
        head.right = new UnRecursiveTraversalBS.Node(3);
        head.left.left = new UnRecursiveTraversalBS.Node(4);
        head.left.right = new UnRecursiveTraversalBS.Node(5);
        head.right.left = new UnRecursiveTraversalBS.Node(6);
        head.right.right = new UnRecursiveTraversalBS.Node(7);

        pre(head);
        System.out.println("========");
        in(head);
        System.out.println("========");
        post(head);
        System.out.println("========");

    }
}
