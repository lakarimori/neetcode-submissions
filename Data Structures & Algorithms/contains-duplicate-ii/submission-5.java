class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int l=0; l<nums.length; l++) {
            for (int r=l+1;r<=Math.min(nums.length-1, l+k); r++) {
                if (nums[l] == nums[r]) {
                    return true;
                }
            }
        }

        return false;
    }
}