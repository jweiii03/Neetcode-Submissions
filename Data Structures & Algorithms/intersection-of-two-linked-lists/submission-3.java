/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// Time complexity: O(n + m), where n is length of one linked list, and m is length of the other linked list
// Space complexity: O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // If no intersection, both ptrs will traverse to end of each list, and both end up = null at same time, hence breaks out of while loop as well and returns null
        ListNode ptrA = headA; 
        ListNode ptrB = headB;

        while (ptrA != ptrB) {
            if (ptrA == null) {
                ptrA = headB;
                continue;
            }

            if (ptrB == null) {
                ptrB = headA;
                continue;
            }

            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }

        return ptrA;
    }
}