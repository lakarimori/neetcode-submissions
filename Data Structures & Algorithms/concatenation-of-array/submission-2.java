class Solution {
    public int[] getConcatenation(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length * 2];
        int counter = 1;

        for (int i=0; i<length;i++) {
            int temp = nums[i];
            ans[i] = temp;
            ans[i+length] = temp;
        }
        
        return ans;
    }
}