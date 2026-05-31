class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int result = 0;

        for (int i=0; i<nums.length; i++) {
            int min = nums[i];
            int max = nums[i];

            for (int j=i; j<nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);

                if (max - min > limit) {
                    break;
                }

                result = Math.max(result, Math.abs(i-j)+1);
            }
        }

        return result;
    }
}