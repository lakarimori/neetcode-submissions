class Solution {
    public int findMin(int[] nums) {
        int r = nums.length-1, l = 0;
        int res = nums[0];

        while (l <= r) {
            if (nums[l] < nums[r]) {
                return Math.min(res, nums[l]);
            }

            int half = l+(r-l) / 2;
            res = Math.min(res, nums[half]);
            if (nums[half] >= nums[l]) {
                l=half+1;
            } else {
                r = half-1;
            }
        }

        return res;
    }
}
