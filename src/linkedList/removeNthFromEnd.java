package linkedList;

/**
 * 本题题目条件：
 * 1. 只给了一个完整的链表
 * 2. 需要删除倒数指定的结点
 */

/**
 * 两种方法：正向的和逆向的
 */

public class removeNthFromEnd {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(5);
//         l1.next = l2;
//         l2.next = l3;
//         l3.next = l4;
//         l4.next = l5;
        ListNode listNode = remove(l1, 1);

    }
    public static ListNode remove(ListNode head, int n) {
        int len = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = dummy.next;
        while(p != null){
            len++;
            p = p.next;
        }
        p = dummy;
        int dif = len - n;
        while(dif > 0){
            p = p.next;
            dif--;
        }
        ListNode q = p.next.next;
        p.next = q;
        return dummy.next;
    }
    public ListNode remove2(ListNode head, int n) {
        ListNode reverseNode = reverse(head);
        ListNode dummy = new ListNode();
        dummy.next = reverseNode;
        ListNode p = dummy;
        while(n - 1 > 0){
            p = p.next;
            n--;
        }
        p.next = p.next.next;
        return reverse(dummy.next);
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = head, q = head.next, h = null;
        while(q != null){
            h = q.next;
            q.next = p;
            p = q;
            q = h;
        }
        head.next = null;
        head = p;
        return head;
    }
}

/**
 * 时间复杂度:O(len)
 * 空间复杂度:o(1)
 */
