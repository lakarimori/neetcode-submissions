class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0];
        int minSum = nums[0];
        int curSum = 0;
        int curMin = 0;
        int total = 0;

        for (int num : nums) {
            curSum = Math.max(curSum + num, num);
            curMin = Math.min(curMin + num, num);
            maxSum = Math.max(maxSum, curSum);
            minSum = Math.min(minSum, curMin);
            total += num;
        }

        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}