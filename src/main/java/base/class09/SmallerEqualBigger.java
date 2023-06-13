package base.class09;

/**
 * @author Liang
 * @date 2023/6/12 - 15:55
 */
public class SmallerEqualBigger {
    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value = data;
        }
    }

    public static Node listPartition1(Node head, int pivot){
        if(head == null){
            return head;
        }
        Node cur = head;
        int i = 0;
        while (cur != null){
            i++;
            cur = cur.next;
        }
        Node[] nodes = new Node[i];
        i = 0;
        cur = head;
        for(i = 0; i != nodes.length; i++){
            nodes[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodes, pivot);
        for(i = 1; i < nodes.length; i++){
            nodes[i - 1].next = nodes[i];
        }
        nodes[i].next = null;
        return nodes[0];
    }

    private static void arrPartition(Node[] nodes, int pivot) {
        int small = -1;
        int big = nodes.length;
        int index = 0;
        while (index != big){
            if(nodes[index].value < pivot){
                swap(nodes, ++small, index++);
            }else if(nodes[index].value == pivot){
                index++;
            }else {
                swap(nodes, --big, index);
            }
        }
    }

    private static void swap(Node[] nodes, int i, int j) {
        Node tmp = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = tmp;
    }

    public static Node listPartition2(Node head, int pivot){
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        Node next = null;

        while (head != null){
            next = head.next;
            head.next = null;
            if(head.value < pivot){
                if(sH == null){
                    sH = head;
                    sT = head;
                }else {
                    sT.next = head;
                    sT = head;
                }
            }else if(head.value == pivot){
                if(eH == null){
                    eH = head;
                    eT = head;
                }else {
                    eT.next = head;
                    eT = head;
                }
            }else {
                if(bH == null){
                    bH = head;
                    bT = head;
                }else {
                    bT.next = head;
                    bT = head;
                }
            }

            head = next;
        }
        if(sH != null){
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if(eT != null){
            eT.next = bH;
        }

        return sH != null ? sH : (eH != null ? eH : bH);
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = listPartition2(head1, 5);
        printLinkedList(head1);

    }
}
