class Trie {
    public Map<Character, Trie> children;
    public boolean isWord;

    public Trie() {
        children = new HashMap<>();
        isWord = false;
    }
}

class PrefixTree {
    Trie trie;

    public PrefixTree() {
        trie = new Trie();
    }

    public void insert(String word) {
        Trie curr = trie;
        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new Trie());
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        Trie curr = trie;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            
            curr = curr.children.get(c);
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        Trie curr = trie;
        for (char c : prefix.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            
            curr = curr.children.get(c);
        }
        return true;
    }
}
