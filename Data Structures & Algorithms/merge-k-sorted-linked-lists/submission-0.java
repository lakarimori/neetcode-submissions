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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode();
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> a.val - b.val);

        for (ListNode node : lists) {
            while (node != null) {
                queue.add(node);
                node = node.next;
            }
        }

        int size = queue.size();
        ListNode[] sortedList = queue.toArray(new ListNode[0]);
        ListNode temp = result;

        while (!queue.isEmpty()) {
            temp.next = new ListNode(queue.poll().val);
            temp = temp.next;
        }

        return result.next;
    }
}
