class Solution {
    List<Integer> currSum = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, target, 0, 0);

        return result;
    }

    private void dfs(int[] nums, int target, int sum, int i) {
        if (i >= nums.length) {
            return;
        }

        sum += nums[i];
        currSum.add(nums[i]);

        if (sum == target) {
            result.add(new ArrayList<>(currSum));
            sum -= nums[i];
            currSum.remove(currSum.size()-1);
            dfs(nums, target, sum, i + 1);
            return;
        }

        if (sum < target) {
            dfs(nums, target, sum, i);
            sum -= nums[i];
            currSum.remove(currSum.size()-1);
            dfs(nums, target, sum, i+1);
        } else {
            sum -= nums[i];
            currSum.remove(currSum.size()-1);
            dfs(nums, target, sum, i+1);
        }
    }
}
