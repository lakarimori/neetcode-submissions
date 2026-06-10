class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0;
        List<Integer> result = new ArrayList<>();
        for (int r=k; r<=nums.length; r++) {
            int maxValue = Integer.MIN_VALUE;
            for (int temp = l; temp<r; temp++) {
                maxValue = Math.max(maxValue, nums[temp]);
            }
            l++;
            result.add(maxValue);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
