package leetcode.linkedlist;

public class $203_RemoveLinkedListElements {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode fakeNode = new ListNode(0);
        fakeNode.next = head;

        ListNode preNode = fakeNode;

        while (head != null) {
            while (head != null && head.val == val) {
                head = head.next;
                preNode.next = head;
            }
            if (head == null) {
                break;
            }
            head = head.next;
            preNode = preNode.next;
        }
        return fakeNode.next;
    }
}
