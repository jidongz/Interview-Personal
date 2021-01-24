package leetcode.linkedlist;

public class $61_RotateList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode result = null;
        int length = 1;
        ListNode slow = head;
        ListNode fast = head;
        int j = k + 1;

        while (fast != null && fast.next != null) {
            fast = fast.next;
            length++;
            j--;
            if (j <= 0) {
                slow = slow.next;
            }
        }

        if (j <= 0) {
            fast.next = head;
        } else {
            int m = k % length;
            fast.next = head;
            for (int i = 1; i < length - m; i++) {
                slow = slow.next;
            }
        }
        result = slow.next;
        slow.next = null;
        return result;
    }
}
