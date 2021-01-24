package leetcode.linkedlist;

public class $21_MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode fakeNode = new ListNode(0);
        ListNode preNode = fakeNode;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                preNode.next = l2;
                break;
            }
            if (l2 == null) {
                preNode.next = l1;
                break;
            }
            if (l1.val < l2.val) {
                preNode.next = l1;
                l1 = l1.next;
            } else {
                preNode.next = l2;
                l2 = l2.next;
            }
            preNode = preNode.next;
        }
        return fakeNode.next;
    }

    //Reference
    public ListNode mergeTwoLists_2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), tail = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 == null ? l2 : l1;
        return head.next;
    }

    public ListNode mergeTwoLists_3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode mergeNode;
        if (l1.val < l2.val) {
            mergeNode = l1;
            mergeNode.next = mergeTwoLists(l1.next, l2);
        } else {
            mergeNode = l2;
            mergeNode.next = mergeTwoLists(l1, l2.next);
        }
        return mergeNode;
    }
}
