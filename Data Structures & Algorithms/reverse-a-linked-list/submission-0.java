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
        if (head == null) {
            return null;
        }

        Stack<ListNode> stacked = new Stack<>();
        ListNode temp = head;
        
        while (temp != null) {
            stacked.push(temp);
            temp = temp.next;
        }

        ListNode result = stacked.pop();
        ListNode current = result;

        while (!stacked.empty()) {
            current.next = stacked.pop();
            current = current.next;
        }
        
        current.next = null;

        return result;
    }
}
