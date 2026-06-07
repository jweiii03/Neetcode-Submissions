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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Edge case
        if (head == null || head.next == null) {
            return null;
        }

        ListNode temp = head;
        ListNode ahead = head;

        for (int i = n; i > 0; i--) {
            ahead = ahead.next;
        }

        // If ahead is null, it means we need to remove the head node
        if (ahead == null) {
            return head.next;
        }

        while (ahead.next != null) {
            ahead = ahead.next;
            temp = temp.next;
        }

        // Delete node
        temp.next = temp.next.next;
        return head;
    }
}
