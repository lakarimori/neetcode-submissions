class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int total = 0;
        int minLen = Integer.MAX_VALUE;
        int left = 0;

        for (int r=0; r<nums.length; r++) {
            total += nums[r];

            while (total >= target) {
                minLen = Math.min(minLen, r-left+1);
                total -= nums[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}