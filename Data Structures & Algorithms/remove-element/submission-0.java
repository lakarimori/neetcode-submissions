class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;

        for (int i=0; i<nums.length;i++) {
            if (nums[i] == val) {
                nums[i] = -1;
            } else {
                count++;
            }
        }

        for (int i=nums.length-1; i>=0;i--) {
            if (nums[i] == -1) {
                for (int j=i; j<nums.length-1; j++) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            } 
        }

        return count;
    }
}