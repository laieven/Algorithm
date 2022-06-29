package linkedList;

/**
 * 本题题目条件：
 * 1. 只给了一个完整的链表
 * 2. 需要删除倒数指定的结点
 */

import java.util.LinkedList;
import java.util.List;

/**
 * 两种方法：正向的和逆向的
 * 当然还可以使用栈
 */

public class removeNthFromEnd {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
         l1.next = l2;
         l2.next = l3;
         l3.next = l4;
         l4.next = l5;
        ListNode listNode = remove3(l1, 2);

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
    public static ListNode remove2(ListNode head, int n) {
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
    private static ListNode reverse(ListNode head){
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
    public static ListNode remove3(ListNode head, int n){
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = dummy;
        LinkedList<ListNode> stack = new LinkedList<>();
        while(p != null){
            stack.push(p);
            p = p.next;
        }
        for(int i = 0; i  < n; i++){
            stack.pop();
        }
        ListNode q = stack.peek();
        q.next = q.next.next;
        return dummy.next;
    }
}

/**
 * 时间复杂度: O(len)
 * 空间复杂度: O(1)
 *
 * 使用栈的时间复杂度和空间复杂度: O(len)，因为使用了额外空间栈
 */
