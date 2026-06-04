class Solution {
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        Map<Integer, String> phoneDigits = new HashMap<>();
        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (int i=2; i<=9; i++) {
            phoneDigits.put(i, letters[i-2]);
        }

        dfs(phoneDigits, digits, 0, new StringBuilder());

        return result;
    }

    private void dfs(Map<Integer, String> phoneDigits, String digits, int position, StringBuilder currStr) {
        if (digits.length() != 0 && position == digits.length()) {
            result.add(currStr.toString());
        }

        if (position >= digits.length()) {
            return;
        }

        for (char c : phoneDigits.get(digits.charAt(position)-'0').toCharArray()) {
            currStr.append(c);
            dfs(phoneDigits, digits, position+1, currStr);
            currStr.deleteCharAt(currStr.length()-1);
        }
    }
}
