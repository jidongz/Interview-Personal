package leetcode.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class $23_MergeKSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode fakeHead = new ListNode(0);
        ListNode pre = fakeHead;

        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            pre.next = queue.poll();
            pre = pre.next;
            if (pre.next != null) {
                queue.add(pre.next);
            }
        }
        return fakeHead.next;
    }
}
