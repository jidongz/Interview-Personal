package leetcode.linkedlist;

public class $147_InsertionSortList {

    /**
     * 对链表进行插入排序。
     * <p>
     * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
     * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val < cur.next.val) {
                cur = cur.next;
                continue;
            }

            ListNode insert = fakeHead;
            while (insert.next.val < cur.next.val) {
                insert = insert.next;
            }

            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = insert.next;
            insert.next = tmp;
        }
        return fakeHead.next;
    }
}
