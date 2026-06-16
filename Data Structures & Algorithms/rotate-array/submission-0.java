class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        while (k > 0) {
            int tmp = nums[n - 1];
            for (int i = n - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = tmp;
            k--;
        }
    }

    /*
    [1,2,3,4,5,6,7,8] k=1
    []
    */
}