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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // revert from slow
        ListNode prev = null;
        ListNode temp = slow.next;

        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        while (prev != null && head != null) {
            ListNode tmp1 = head.next;
            ListNode tmp2 = prev.next;
            head.next = prev;
            prev.next = tmp1;
            head = tmp1;
            prev = tmp2;
        }
    }
}
