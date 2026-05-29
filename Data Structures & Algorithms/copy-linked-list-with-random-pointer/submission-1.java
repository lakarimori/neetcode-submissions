/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        Node copy = new Node(head.val);
        Map<Node, Node> seen = new HashMap<>();
        seen.put(head, copy);

        Node curr = head;
        Node copyCurr = copy;
        while (curr != null) {
            if (curr.next == null) {
                copyCurr.next = null;
            } else {
                copyCurr.next = new Node(curr.next.val);
            }
            seen.put(curr.next, copyCurr.next);
            copyCurr = copyCurr.next;
            curr = curr.next;
        }

        curr = head;
        copyCurr = copy;
        while (curr != null) {
            copyCurr.random = seen.get(curr.random);
            copyCurr = copyCurr.next;
            curr = curr.next;
        }

        return copy;
    }
}
