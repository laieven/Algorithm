package linkedList;


/**
 * [本题](https://leetcode.cn/problems/add-two-numbers/)条件：
 * 1. 两个非空的链表
 * 2. 数字是逆序存储的
 * 3. 数字不会以0开头
 */


public class TwoSum {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l11.next =l12;
        l12.next = l13;
        ListNode l1 = l11;

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;
        ListNode l2 = l21;

        TwoSum solution = new TwoSum();
        ListNode res = solution.addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        int sum = 0, carry = 0;
        while(l1 != null && l2 != null){
            sum += l1.val + l2.val + carry;
            if(sum > 9){
                carry = sum / 10;
                sum -= 10;
            } else {
                carry = 0;
            }
            ListNode s = new ListNode(sum);
            p.next = s;
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            sum += l1.val + carry;
            if(sum > 9){
                carry = sum / 10;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            ListNode s= new ListNode(sum);
            p.next = s;
            p = p.next;
            l1 = l1.next;
        }
        while(l2 != null){
            sum += l2.val + carry;
            if(sum > 9){
                carry = sum / 10;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            ListNode s= new ListNode(sum);
            p.next = s;
            p = p.next;
            l2 = l2.next;
        }
        if(carry > 0){
            ListNode s = new ListNode(carry);
            p.next = s;
            p = p.next;
        }
        return dummy.next;
    }
}


