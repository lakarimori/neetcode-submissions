class Solution {
    public int pivotIndex(int[] nums) {
        int[] rightSum = Arrays.copyOf(nums, nums.length);

        for (int i=1; i<nums.length; i++) {
            nums[i] += nums[i-1];
        }

        for (int i=rightSum.length-2; i>=0; i--) {
            rightSum[i] += rightSum[i+1];
        }

        for (int i=0; i<nums.length; i++) {
            if (nums[i] - rightSum[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}