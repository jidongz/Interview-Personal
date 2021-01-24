package leetcode.linkedlist;

public class $83_RemoveDuplicatesfromSortedList {

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

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null) {
            if (fast.val != slow.val) {
                slow = fast;
                fast = fast.next;
                continue;
            }

            while (fast.val == slow.val) {
                fast = fast.next;
                if (fast == null) {
                    break;
                }
            }
            slow.next = fast;
        }
        return head;
    }

    public ListNode deleteDuplicates_2(ListNode head) {
        if (head == null) return null;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;

        //使用两个指针指代重复元素的开始和结束
        ListNode slow = head, fast = head;
        while (slow != null && slow.next != null) {
            //如果相邻两个元素不同，直接跳过
            if (slow.next.val != slow.val) {
                slow = slow.next;
                continue;
            }
            fast = slow;

            //如果有相同元素，找到最后一位相同元素，用fast指代
            while (fast.next != null && fast.next.val == slow.val) {
                fast = fast.next;
            }

            //删除重复元素
            slow.next = fast.next;
            slow = slow.next;

        }
        return fakeHead.next;
    }
}
