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
    public ListNode reverseList(ListNode head) {
        
        // Edge cases
        if (head == null)   return null;
        if (head.next == null)  return head;

        ListNode prev = head;
        ListNode front = head.next;
        prev.next = null;

        while (front != null) {
            ListNode temp = front.next;
            front.next = prev;
            prev = front;
            front = temp;
        }

        return prev;
    }
}
