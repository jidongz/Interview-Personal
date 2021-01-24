package leetcode.linkedlist;

public class $234_PalindromeLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reversed = reverse(slow);

        while (reversed != null) {
            if (head.val != reversed.val) {
                return false;
            }
            head = head.next;
            reversed = reversed.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode preNode = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = preNode;
            preNode = head;
            head = tmp;
        }
        return preNode;
    }
}
