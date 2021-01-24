package leetcode.linkedlist;

public class $82_RemoveDuplicatesFromSortedListII {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;

        ListNode pre = fakeHead;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null) {
            while (slow.val != fast.val) {
                pre = slow;
                slow = fast;
                fast = fast.next;
                if (fast == null) {
                    return fakeHead.next;
                }
            }

            while (slow.val == fast.val) {
                fast = fast.next;
                if (fast == null) {
                    pre.next = null;
                    return fakeHead.next;
                }
            }
            slow = fast;
            fast = fast.next;
            pre.next = slow;
        }
        return fakeHead.next;
    }

    //reference
    public ListNode deleteDuplicates_2(ListNode head) {
        ListNode fakeHead = new ListNode(0), pre = fakeHead, slow = head, fast = head;
        fakeHead.next = head;
        while (fast != null && fast.next != null) {
            //如果当前元素不是重复元素
            while (fast.next != null && slow.val != fast.next.val) {
                pre = slow;
                slow = slow.next;
                fast = slow;
            }
            while (fast.next != null && slow.val == fast.next.val) {
                fast = fast.next;
            }
            //删除重复元素
            if (slow != fast) {
                pre.next = fast.next;
                slow = pre.next;
                fast = slow;
            }
        }
        return fakeHead.next;
    }
}
