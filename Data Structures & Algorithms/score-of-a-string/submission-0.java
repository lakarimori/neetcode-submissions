class Solution {
    public int scoreOfString(String s) {
        char[] charArray = s.toCharArray();
        int result = 0;

        for (int i=0; i<s.length()-1; i++) {
            result += Math.abs(charArray[i] - charArray[i+1]);
        }

        return result;
    }
}