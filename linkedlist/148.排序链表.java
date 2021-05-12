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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left,right);
    }

    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                temp.next = node1;
                node1 = node1.next;
            }else {
                temp.next = node2;
                node2 = node2.next;
            }
            temp = temp.next;
        }
        if (node1 != null) temp.next = node1;
        else if (node2 != null) temp.next = node2;
        return dummy.next;
    }
}
