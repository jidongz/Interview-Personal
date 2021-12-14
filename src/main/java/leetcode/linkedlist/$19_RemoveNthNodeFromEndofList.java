package leetcode.linkedlist;

public class $19_RemoveNthNodeFromEndofList {

     /*
     20210206
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode slow = fakeHead;
        ListNode fast = fakeHead;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return fakeHead.next;
    }
}
