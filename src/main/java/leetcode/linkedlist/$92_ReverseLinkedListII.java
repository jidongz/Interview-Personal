package leetcode.linkedlist;

public class $92_ReverseLinkedListII {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;

        ListNode preNode = fakeHead;

        int count = 1;
        while (count < m) {
            preNode = preNode.next;
            count++;
        }

        ListNode curNode = preNode.next;
        ListNode futureNode = null;

        /**
         * step 0: set futureNode = curNode.next
         * step 1: curNode.next point to futureNode's next
         * step 2: futureNode's next = preNode's next  (exchange node)
         * step 3: preNode.next = futureNode
         */
        for (int i = 0; i < n - m; i++) {
            if (curNode != null && curNode.next != null) {
                //curNode is always be the last node.
                //futureNode is always be the next one of curNode.
                futureNode = curNode.next;
                curNode.next = futureNode.next;
                futureNode.next = preNode.next;
                preNode.next = futureNode;
            }
        }
        return fakeHead.next;
    }
}
