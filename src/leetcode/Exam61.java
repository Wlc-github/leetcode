package leetcode;

public class Exam61 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        for (int i = 0; i < 2; i++) {
            node.next = new ListNode(i + 1);
            node = node.next;
        }
        head = rotateRight(head, 4);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        ListNode node = head;
        ListNode temp = head;
        int count = 1;
        while (node.next != null) {
            node = node.next;
            count++;
        }
        node.next = head;
        node = head;
        k = k % count;
        for (int i = 0; i < k; i++)
            node = node.next;
        while (node != head) {
            node = node.next;
            temp = temp.next;
        }
        head = temp;
        for (int i = 1; i < count; i++)
            temp = temp.next;
        temp.next = null;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
