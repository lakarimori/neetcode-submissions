class NumArray {
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int left, int right) {
        int[] prefix = new int[right+1];
        prefix[left] = nums[left];
        for (int i=left+1; i<=right; i++) {
            prefix[i] += prefix[i-1] + nums[i];
        }
        return prefix[right];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */