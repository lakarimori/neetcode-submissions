class Solution {
    Map<Integer, Node> seen = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return deepCopy(node);
    }

    private Node deepCopy(Node node) {
        if (seen.containsKey(node.val)) {
            return seen.get(node.val);
        }

        Node copy = new Node(node.val);
        seen.put(node.val, copy);

        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(deepCopy(neighbor));
        }
        
        return copy;
    }
}