class Solution {
    /*
    [1,2,4,6]
    ->
    [1,1,2,8]
    <-
    [48,24,6,1]
    */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] prefix = new int[n];
        int[] posfix = new int[n];

        prefix[0] = 1;
        for (int i=1; i<nums.length;i++) {
            prefix[i] = nums[i-1] * prefix[i-1];
        }

        posfix[n-1] = 1;
        for (int i=n-2; i>=0;i--) {
            posfix[i] = nums[i+1] * posfix[i+1];
        }

        for (int i=0; i<nums.length;i++) {
            result[i] = prefix[i] * posfix[i];
        }

        return result;
    }
}  
