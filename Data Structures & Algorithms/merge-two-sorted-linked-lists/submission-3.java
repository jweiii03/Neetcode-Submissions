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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Edge case;
        if (list1 == null)  return list2;
        if (list2 == null)  return list1;

        ListNode dummy = new ListNode(0);
        ListNode tracker = dummy;
        ListNode ptr1 = list1, ptr2 = list2;
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val > ptr2.val) {
                tracker.next = ptr2;
                ptr2 = ptr2.next;
            } else {
                tracker.next = ptr1;
                ptr1 = ptr1.next;
            }
            tracker = tracker.next;
        }

        if (ptr1 != null) {
            tracker.next = ptr1;
        } else {
            tracker.next = ptr2;
        }

        return dummy.next;
    }
}