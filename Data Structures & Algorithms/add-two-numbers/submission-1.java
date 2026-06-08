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
        // Reverse order means starting from ones place, if addition >= 10, carry on to next number place
        ListNode dummyNode = new ListNode(0);
        ListNode tracker = dummyNode;
        int carry = 0;
        
        // We use OR here to handle uneven length of both lists
        while (l1 != null || l2 != null) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;
            int currVal = sum % 10;

            tracker.next = new ListNode(currVal);
            tracker = tracker.next;
            // Move pointers only if the node exists
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Edge case where both list reach the end but there is still a carry value
        if (carry > 0) {
            tracker.next = new ListNode(carry);
        }

        return dummyNode.next;
    }
}
