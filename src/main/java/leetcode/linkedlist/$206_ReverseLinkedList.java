package leetcode.linkedlist;

public class $206_ReverseLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode tail = head.next;
        ListNode reversed = reverseList(head.next);

        tail.next = head;
        head.next = null;

        return reversed;
    }

    public ListNode reverseList_2(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode preNode = null;
        ListNode futureNode = null;

        while (head != null) {
            futureNode = head.next;
            head.next = preNode;
            preNode = head;
            head = futureNode;
        }
        return preNode;
    }

}
