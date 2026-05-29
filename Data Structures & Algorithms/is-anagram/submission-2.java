class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        for (char c : s.toCharArray()) {
            String currentChar = String.valueOf(c);
            if (t.contains(currentChar)) {
                t = t.replaceFirst(currentChar, "");
            } else {
                return false;
            }
        }

        return true;
    }
}
