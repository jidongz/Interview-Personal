package leetcode.linkedlist;

public class $143_ReorderList {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverse = reverse(slow.next);
        slow.next = null;

        ListNode cur = head;
        while (reverse != null) {
            ListNode tmp = reverse.next;
            reverse.next = cur.next;
            cur.next = reverse;
            cur = cur.next.next;
            reverse = tmp;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;

        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
}
