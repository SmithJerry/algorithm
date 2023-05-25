package base.class03;

/**
 * @author Liang
 * @date 2023/5/25 - 10:48
 */
public class DeleteGivenValue {
    public static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public static Node removeValue(Node head, int num){
        while (head != null){
            if(head.value != num){
                break;
            }
            head = head.next;
        }

        Node pre = head;
        Node cur = head;
        while (cur != null){
            if(cur.value == num){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }

        return head;
    }
}
