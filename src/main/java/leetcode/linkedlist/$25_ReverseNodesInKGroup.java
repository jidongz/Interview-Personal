package leetcode.linkedlist;

public class $25_ReverseNodesInKGroup {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode headCount = head;

        int count = 0;
        while (headCount != null) {
            headCount = headCount.next;
            count++;
        }

        int num = count / k;
        if (num == 0) {
            return head;
        }

        ListNode start = head;
        ListNode fakeHead = new ListNode(0);

        ListNode pre = null;
        for (int i = 0; i < num; i++) {
            if (i == 0) {
                fakeHead.next = reverse(start, k);
            } else {
                pre.next = reverse(start, k);
            }
            pre = start;
            start = start.next;
        }
        return fakeHead.next;
    }

    private ListNode reverse(ListNode start, int k) {
        ListNode pre = null;
        ListNode head = start;
        ListNode next = null;
        for (int i = 0; i < k; i++) {
            if (i == k - 1) {
                next = head.next;
            }
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        start.next = next;
        return pre;
    }

    //reference
    public ListNode reverseKGroup_2(ListNode head, int k) {
        if (head == null) return null;
        //1.获得链表节点个数
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        //2.获得需要翻转的组数
        int group = count / k;
        ListNode fakeHead = new ListNode(0), pre = fakeHead;
        cur = head;
        fakeHead.next = head;
        //3.开始翻转
        while (group-- > 0) {
            //3.1 组内翻转k-1次
            for (int i = 0; i < k - 1; i++) {
                ListNode tmp = cur.next;
                cur.next = tmp.next;
                tmp.next = pre.next;
                pre.next = tmp;
            }
            //3.2 开始下一次翻转
            pre = cur;
            cur = cur.next;
        }
        return fakeHead.next;
    }
}
