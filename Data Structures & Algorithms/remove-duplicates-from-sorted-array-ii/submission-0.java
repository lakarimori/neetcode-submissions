class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        
        int l = 2;
        int n = nums.length;
        
        for (int r = 2; r < n; r++) {
            if (nums[r] != nums[l - 2]) {
                nums[l] = nums[r];
                l++;
            }
        }

        return l;
    }
}