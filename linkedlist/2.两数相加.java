/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        int val = 0;
        while (l1 != null || l2 != null) {
           int a = l1 == null ? 0 : l1.val;
           int b = l2 == null ? 0 : l2.val; 
           int temp = a + b + carry;
           val =  temp % 10;
           carry = temp / 10;
           cur.next = new ListNode(val);
           cur = cur.next;
           if (l1 != null) l1 = l1.next;
           if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) cur.next = new ListNode(1);
        return dummy.next;
    }
}
