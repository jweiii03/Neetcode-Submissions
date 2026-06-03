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

// Time Complexity: O(n), Finding middle node = O(n/2), reverse second half of list = O(n/2), merging = O(n/2) 
// Space Complexity: O(1)
class Solution {
    public void reorderList(ListNode head) {
        // Idea: Find the middle of the linked list -> Split into two equal halves
        // Then reverse the second half, and then reorder the list by alternating from both halves

        // Find the middle of the linked list using fast and slow pointer 
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next; // End of this loop, slow will be pointing to middle of linked list
        }

        // Reverse second half of list, requires 3 ptrs
        ListNode front = slow.next;
        ListNode prev = slow.next = null;
        while (front != null) {
            ListNode temp = front.next;
            front.next = prev;
            prev = front;
            front = temp;
        }

        // Now have two equal halves where head and prev ptr point to start of each list
        // prev ptr points to second half of list since its reversed
        ListNode first = head; // Pointer to start of first half
        ListNode second = prev; // Pointer to second half
        while (second != null && first != null) {
            ListNode temp = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp;
            second = temp2;
            first = temp;
        }
    }
}
