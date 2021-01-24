package leetcode.linkedlist;

public class $24_SwapNodesInPair {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head.next;

        ListNode odd = head;
        ListNode even = head.next;

        while (odd != null && even != null) {
            ListNode nextOdd = even.next;
            ListNode nextEven = null;
            if (nextOdd != null) {
                nextEven = nextOdd.next;
            }
            even.next = odd;
            if (nextEven != null) {
                odd.next = nextEven;
            } else {
                odd.next = nextOdd;
            }
            odd = nextOdd;
            even = nextEven;
        }
        return fakeHead.next;
    }

    //reference
    public ListNode swapPairs_2(ListNode head) {
        if (head == null) return null;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode odd = head, p = fakeHead, even = null;
        while (odd != null && odd.next != null) {
            //获取偶数位节点
            even = odd.next;
            //交换
            odd.next = even.next;
            even.next = odd;
            p.next = even;
            //进入到下一对
            p = odd;
            odd = odd.next;
        }
        return fakeHead.next;
    }
}
