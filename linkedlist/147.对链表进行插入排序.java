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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = new ListNode(0);
        ListNode cur = head.next;
        ListNode tail = head;
        while (cur != null) {
            if (cur.val >= tail.val) {
                tail = tail.next;
            } else {
                pre = dummy;
                while (pre.next.val < cur.val) {
                    pre = pre.next;
                }
                tail.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = tail.next;
        }
        return dummy.next;
    }
}
