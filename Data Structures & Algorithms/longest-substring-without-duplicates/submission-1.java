class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, longest = 0;
        Set<Character> charSet = new HashSet<>();

        for (int r=0; r < s.length(); r++) {
            while (charSet.contains(s.charAt(r))) {
                charSet.remove(s.charAt(l));
                l++;
            }

            charSet.add(s.charAt(r));
            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }
}
