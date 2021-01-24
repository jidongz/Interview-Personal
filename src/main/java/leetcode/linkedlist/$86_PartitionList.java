package leetcode.linkedlist;

public class $86_PartitionList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode moreHead = new ListNode(0);
        moreHead.next = head;
        ListNode preMoreHead = moreHead;
        ListNode lessHead = new ListNode(0);
        ListNode lessCur = lessHead;

        while (head != null) {
            if (head.val < x) {
                preMoreHead.next = head.next;

                lessCur.next = head;
                lessCur = head;

                head = head.next;
                lessCur.next = null;
            } else {
                preMoreHead = head;
                head = head.next;
            }
        }
        lessCur.next = moreHead.next;
        return lessHead.next;
    }

    //reference
    public ListNode partition_2(ListNode head, int x) {
        if (head == null) return null;
        ListNode moreListNode = new ListNode(0), lessListNode = new ListNode(0), cur = head;
        moreListNode.next = head;
        ListNode preMore = moreListNode, preLess = lessListNode;
        while (cur != null) {
            //判断当前节点大小
            if (cur.val < x) {
                //放入新链表中
                ListNode tmp = cur.next;
                preMore.next = tmp;
                preLess.next = cur;
                preLess = preLess.next;
                cur = tmp;
            } else {
                //保留在原链表
                preMore = cur;
                cur = cur.next;
            }
        }
        //合并
        preLess.next = moreListNode.next;
        return lessListNode.next;
    }
}
