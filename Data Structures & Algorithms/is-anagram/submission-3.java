class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        for (char c : s.toCharArray()) {
            if (t.contains(String.valueOf(c))) {
                t = t.replaceFirst(String.valueOf(c), "");
            } else {
                return false;
            }
        }

        return true;
    }
}
