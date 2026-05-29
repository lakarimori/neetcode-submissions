class Solution {
    private Map<Character, Set<Character>> charTree = new HashMap<>();
    private Map<Character, Boolean> visited = new HashMap<>();
    private List<Character> result = new ArrayList();;


    public String foreignDictionary(String[] words) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                charTree.putIfAbsent(c, new HashSet<>());
            }
        }

        //Compare each pair
        for (int i=0; i<words.length-1; i++) {
            String currentWord = words[i];
            String nextWord = words[i+1];

            int minLen = Math.min(currentWord.length(), nextWord.length());
            if (currentWord.length() > nextWord.length() &&
                currentWord.substring(0, minLen).equals(nextWord.substring(0, minLen))) {
                    return "";
                }

            for (int j=0; j<minLen; j++) {
                if (currentWord.charAt(j) != nextWord.charAt(j)) {
                    charTree.get(currentWord.charAt(j)).add(nextWord.charAt(j));
                    break;
                }
            }
        }

        for (char c : charTree.keySet()) {
            if (dfs(c)) {
                return "";
            }
        }

        print(charTree);
        for (char c : result) {
            System.out.println("result: " + c);
        }

        Collections.reverse(result);
        String finalResult = "";

        for (char c : result) {
            finalResult += c;
        }

        return finalResult;
    }

    private boolean dfs(char c) {
        if (visited.containsKey(c)) {
            return visited.get(c);
        }

        System.out.println("analyzing char: " + c);
        visited.put(c, true);

        for (char next : charTree.get(c)) {
            System.out.println("next char: " + next);
            if (dfs(next)) {
                return true;
            }
        }

        System.out.println("setting false in char: " + c);
        visited.put(c, false);
        result.add(c);
        return false;
    }

    private void print(Map<Character, Set<Character>> charTree) {
        for(Map.Entry<Character, Set<Character>> entry : charTree.entrySet()) {
            System.out.println("key: " + entry.getKey());
            for (char c : entry.getValue()) {
                System.out.println("value: " + c);
            }
        }
    }
}
