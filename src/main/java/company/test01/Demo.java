package company.test01;

/**
 * @author Liang
 * @date 2023/8/5 - 10:45
 */
public class Demo {
    public static class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }
    public static void main(String[] args) {
        Node head1= new Node(0);
        for(int i = 0; i < 5; i++){
            head1.next = new Node(i + 1);
        }
        Node head2 = new Node(0);
        for(int i = 0; i < 3; i++){
            head2.next = new Node(i + 2);
        }
        process(head1, head2);
    }

    public static void process(Node h1, Node h2){
        Node result = new Node(0);
        Node h = result;
        while (h1 != null && h2 != null){
            if(h1.value < h2.value){
                h.next = h1;
                h1 = h1.next;
            }else {
                h.next = h2;
                h2 = h2.next;
            }
            h = h.next;
        }
        if(h1 == null){
            h.next = h2;
        }
        if(h2 == null){
            h.next = h1;
        }
        result = result.next;
    }

}
