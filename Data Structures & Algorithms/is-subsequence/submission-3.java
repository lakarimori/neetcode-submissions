class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.isBlank()) {
            return true;
        }

        if (t.length() < s.length()) {
            return false;
        }

        int sPointer = 0;
        for (char c : t.toCharArray()) {
            if (c == s.charAt(sPointer)) {
                sPointer++;
            }

            if (sPointer >= s.length()) {
                break;
            }
        }

        return sPointer >= s.length();
    }
}