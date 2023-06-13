package base.class09;

import java.awt.*;
import java.util.HashMap;

/**
 * @author Liang
 * @date 2023/6/12 - 15:56
 */
public class CopyListWithRandom {
    public static class Node {
        public int value;
        public Node next;
        public Node random;
        public Node(int value){
            this.value = value;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList1(Node head, int pivot){
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null){
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }

    public static Node copyRandomList(Node head){
        if(head == null){
            return null;
        }
        Node cur = head;
        Node next = null;

        while (cur != null){
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node copy = null;
        while (cur != null){
            next = cur.next.next;
            copy = cur.next;
            copy.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }
        Node res = head.next;
        cur = head;

        while (cur != null){
            next = cur.next.next;
            copy = cur.next;
            cur.next = next;
            copy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }
}
