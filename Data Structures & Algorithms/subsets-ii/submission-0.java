class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);

        backtrack(nums, curr, result, 0);

        return new ArrayList<>(result);
    }

    private void backtrack(int[] nums, List<Integer> curr, Set<List<Integer>> result, int i) {
        if (i == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);

        backtrack(nums, curr, result, i+1);
        curr.remove(curr.size()-1);
        backtrack(nums, curr, result, i+1);
    }
}
