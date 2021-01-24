package leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class $142_LinkedListCycleII {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Use set.
     * If required to not use extra space. See
     * https://www.zybuluo.com/Yano/note/253217#linked-list-cycle
     */

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return null;
    }
}
