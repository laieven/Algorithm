package linkedList;


/**
 * [本题](https://leetcode.cn/problems/add-two-numbers/)条件：
 * 1. 两个非空的链表
 * 2. 数字是逆序存储的
 * 3. 数字不会以0开头
 *
 * 解题思路：
 * 1.
 */


public class TwoSum {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(9);
        ListNode l12 = new ListNode(9);
        ListNode l13 = new ListNode(9);
        ListNode l14 = new ListNode(9);
        ListNode l15 = new ListNode(9);
        ListNode l16 = new ListNode(9);
        ListNode l17 = new ListNode(9);

        l11.next =l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        l15.next = l16;
        l16.next = l17;
        ListNode l1 = l11;

        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        ListNode l23 = new ListNode(9);
        ListNode l24 = new ListNode(9);
        l21.next = l22;
        l22.next = l23;
        l23.next = l24;
        ListNode l2 = l21;

        TwoSum solution = new TwoSum();
        ListNode res = solution.addTwoNumbers2(l1, l2);
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
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        int sum = 0, carry = 0;
        while(l1 != null || l2 != null){
            int n1, n2;
            if(l1 == null){
                n1 = 0;
            }else {
                n1 = l1.val;
            }
            if(l2 == null){
                n2 = 0;
            }else {
                n2 = l2.val;
            }
            sum = n1 + n2 + carry;
            if(sum > 9){
                carry = sum / 10;
                sum -= 10;
            } else {
                carry = 0;
            }
            ListNode s = new ListNode(sum);
            p.next = s;
            p = p.next;
            if(l1 != null) {//道理同l2
                l1 = l1.next;
            }
            if(l2 != null) { //这里不能写写l2.next因为一旦某一个链表走到最后了，那么是无法将最后一个结点算在内的，该链表一直会走不完
                l2 = l2.next;
            }
        }

        if(carry > 0){
            ListNode s = new ListNode(carry);
            p.next = s;
            p = p.next;
        }
        return dummy.next;
    }
}
/**
 * 两个解法对应了不同的写法
 * 其核心的思想还是链表的指针移动，对于链表来说最关键的是记录下一个指针的信息
 */

/**
 * 时间复杂度：O(max(len1, len2)
 * 空间复杂度：O(1)
 */

