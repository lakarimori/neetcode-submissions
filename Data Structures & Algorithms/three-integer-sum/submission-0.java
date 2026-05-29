class Solution {
    /*
    [-1,0,1,2,-1,-4]
    [-4,-1,-1,0,1,2]
    */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length;j++) {
                for (int k=j+1; k<nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }
}
