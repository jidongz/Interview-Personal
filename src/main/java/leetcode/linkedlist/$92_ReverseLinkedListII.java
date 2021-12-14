package leetcode.linkedlist;

public class $92_ReverseLinkedListII {

    /*
    反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

    说明:
    1 ≤ m ≤ n ≤ 链表长度。

    示例:

    输入: 1->2->3->4->5->NULL, m = 2, n = 4
    输出: 1->4->3->2->5->NULL

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode returned = reverseBetween(head, 1, 2);
    }
}
