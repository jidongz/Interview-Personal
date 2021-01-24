package leetcode.linkedlist;

public class $160_IntersectionOfTwoLinkedLists {

    /**
     * 编写一个程序，找到两个单链表相交的起始节点。
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int countA = 1;
        ListNode p = headA;
        while (p.next != null) {
            countA++;
            p = p.next;
        }

        int countB = 1;
        ListNode q = headB;
        while (q.next != null) {
            countB++;
            q = q.next;
        }

        if (p != q) {
            return null;
        }

        if (countA > countB) {
            int tmp = countA - countB;
            while (0 != tmp--) {
                headA = headA.next;
            }
        } else {
            int tmp = countB - countA;
            while (0 != tmp--) {
                headB = headB.next;
            }
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
