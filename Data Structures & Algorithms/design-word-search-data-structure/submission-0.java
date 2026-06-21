class Trie {
    public Map<Character, Trie> children;
    public boolean endWord;

    public Trie() {
        children = new HashMap<>();
        endWord = false;
    }
}

class WordDictionary {
    Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        Trie curr = trie;
        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new Trie());
            curr = curr.children.get(c);
        }
        curr.endWord = true;
    }

    public boolean search(String word) {
        return searchInNode(word, 0, trie);
    }

    private boolean searchInNode(String word, int index, Trie curr) {
        if (index == word.length()) {
            return curr.endWord;
        }

        char c = word.charAt(index);
        if (c == '.') {
            for (Trie child : curr.children.values()) {
                if (searchInNode(word, index + 1, child)) {
                    return true;
                } 
            }
            return false;
        } else {
            if (!curr.children.containsKey(c)) {
                return false;
            } 
            return searchInNode(word, index + 1, curr.children.get(c));
        }
    }
}